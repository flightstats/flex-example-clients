package com.flightstats.flex.flightstatusfeed.client.util;

import com.flightstats.flex.flightstatusfeed.client.util.FeedClient;
import com.flightstats.flex.flightstatusfeed.client.util.FlexCredentials;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyInvocation;
import org.glassfish.jersey.client.JerseyWebTarget;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FeedClientTest {

    public static final URI uri = URI.create("http://foo.bar.com/");
    public static final String ITEM_URL = "http://foo.bar.com/zip";
    public static final String SINGLE_ITEM_JSON = String.format("{\"item\": \"%s\"}", ITEM_URL);
    public static final String MULTI_ITEM_JSON = String.format("{\"items\": [\"%s\"]}", ITEM_URL);
    public static final String ITEM_JSON = "{}";

    @Test
    public void testRetrieveLatestItemURI() throws Exception {
        FeedClient feedClient = mockFeedClientRequest(SINGLE_ITEM_JSON);
        URI result = feedClient.retrieveLatestItemURI();
        Assert.assertEquals(result, URI.create(ITEM_URL));
    }

    @Test
    public void testRetrieveItemAsGson() throws Exception {
        FeedClient feedClient = mockFeedClientRequest(ITEM_JSON);
        JsonObject result = feedClient.retrieveItemAsGson(URI.create("http://foo/"));
        Gson gson = new Gson();
        Assert.assertEquals(result, gson.fromJson(ITEM_JSON, JsonObject.class));
    }

    @Test
    public void testRetrieveItemURIsAfter() throws Exception {
        FeedClient feedClient = mockFeedClientRequest(MULTI_ITEM_JSON);
        List<URI> uris = feedClient.retrieveItemURIsAfter(uri, 5);
        Assert.assertEquals(1, uris.size());
        Assert.assertEquals(uris.get(0), URI.create(ITEM_URL));
    }

    private FeedClient mockFeedClientRequest(String json) throws URISyntaxException {
        FlexCredentials flexCredentials = new FlexCredentials("appId", "appKey");
        JerseyClient jerseyClient = Mockito.mock(JerseyClient.class);
        JerseyWebTarget jerseyWebTarget = Mockito.mock(JerseyWebTarget.class);
        JerseyInvocation.Builder builder = Mockito.mock(JerseyInvocation.Builder.class);

        Mockito.when(jerseyClient.target(Matchers.any(URI.class))).thenReturn(jerseyWebTarget);
        Mockito.when(jerseyWebTarget.request(Matchers.any(MediaType.class))).thenReturn(builder);
        Mockito.when(builder.get(String.class)).thenReturn(json);

        return new FeedClient(flexCredentials, uri, jerseyClient);
    }
}