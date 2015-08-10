package com.flightstats.flex.flightstatusfeed.client.util;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.glassfish.jersey.client.JerseyClient;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;

public class FeedClient {

    private enum IterationDirection { previous, next }

    private final Gson gson = new Gson();
    private final URI flexBaseURI;
    private final JerseyClient jerseyClient;
    private final FlexCredentials credentials;

    public FeedClient(FlexCredentials credentials, URI flexBaseURI, JerseyClient jerseyClient) {
        this.credentials = credentials;
        this.flexBaseURI = flexBaseURI;
        this.jerseyClient = jerseyClient;
    }

    public List<URI> retrieveItemURIsAfter(URI latestURI, int batchSize) {
        return retrieveItemsRelatively(latestURI, batchSize, IterationDirection.next);
    }

    public List<URI> retrieveItemURIsBefore(URI latestURI, int batchSize) {
        return retrieveItemsRelatively(latestURI, batchSize, IterationDirection.previous);
    }

    public URI retrieveLatestItemURI() {
        URI latestURI =
                UriBuilder
                        .fromUri(flexBaseURI)
                        .path("latest")
                        .build();
        JsonObject jsonObject = fetchJson(latestURI);
        return URI.create(jsonObject.getAsJsonPrimitive("item").getAsString());
    }

    public JsonObject retrieveItemAsGson(URI itemURI) {
        return fetchJson(itemURI);
    }

    private List<URI> retrieveItemsRelatively(URI itemURI, int limit, IterationDirection iterationDirection) {
        URI latestURI =
                UriBuilder
                        .fromUri(itemURI)
                        .path(iterationDirection.name())
                        .path(Integer.toString(limit))
                        .build();

        JsonObject jsonObject = fetchJson(latestURI);

        ImmutableList.Builder<URI> listBuilder = ImmutableList.builder();
        for (JsonElement jsonElement : jsonObject.getAsJsonArray("items")) {
            listBuilder.add(URI.create(jsonElement.getAsString()));
        }
        return listBuilder.build();
    }

    private JsonObject fetchJson(URI uri) {
        // insist on https until feed wart is fixed
        uri = UriBuilder
                .fromUri(uri)
                .scheme("https")
                .queryParam("appId", credentials.getAppId())
                .queryParam("appKey", credentials.getAppKey())
                .build();
        String contents =
                jerseyClient
                        .target(uri)
                        .request(MediaType.APPLICATION_JSON_TYPE)
                        .get(String.class);
        return gson.fromJson(contents, JsonObject.class);
    }
}
