package com.flightstats.flex.flightstatusfeed.client;

import com.flightstats.flex.flightstatusfeed.client.util.FeedClient;
import com.flightstats.flex.flightstatusfeed.client.util.FlexCredentials;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Slf4j
public class FetchOneBatch {

    private static final int BATCH_SIZE = 5;
    public static URI flexBaseURL = URI.create("https://api.flightstats.com/flex/flightstatusfeed/rest/v2/json/");

    public static void main(String... args) throws Exception {
        checkParameters(args);
        FeedClient feedClient = buildFeedClient(args[0], args[1]);

        URI latestURI = feedClient.retrieveLatestItemURI();

        List<URI> nextFiveURLs = feedClient.retrieveItemURIsBefore(latestURI, BATCH_SIZE);
        for (URI nextURI : nextFiveURLs) {
            JsonObject next = feedClient.retrieveItemAsGson(nextURI);
            log.debug(next.toString());
        }
    }

    private static FeedClient buildFeedClient(String appId, String appKey) throws URISyntaxException {
        FlexCredentials flexCredentials = new FlexCredentials(appId, appKey);
        JerseyClient jerseyClient = new JerseyClientBuilder().build();
        return new FeedClient(flexCredentials, flexBaseURL, jerseyClient);
    }

    private static void checkParameters(String... args) {
        if (args.length != 2) {
            log.error("arguments are Flex appId & appKey");
            throw new IllegalStateException("<appId> <appKey>");
        }
    }
}
