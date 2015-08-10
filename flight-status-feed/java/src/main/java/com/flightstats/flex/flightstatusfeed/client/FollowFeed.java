package com.flightstats.flex.flightstatusfeed.client;

import com.flightstats.flex.flightstatusfeed.client.util.FeedClient;
import com.flightstats.flex.flightstatusfeed.client.util.FeedFollower;
import com.flightstats.flex.flightstatusfeed.client.util.FeedState;
import com.flightstats.flex.flightstatusfeed.client.util.FeedStateInMemory;
import com.flightstats.flex.flightstatusfeed.client.util.FlexCredentials;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class FollowFeed {

    private static final int BATCH_SIZE = 5;
    public static URI flexBaseURL = URI.create("https://api.flightstats.com/flex/flightstatusfeed/rest/v2/json/");

    public static void main(String... args) throws Exception {
        checkParameters(args);
        FeedClient feedClient = buildFeedClient(args[0], args[1]);
        startAtLatest(feedClient, new FeedStateInMemory());
    }

    private static FeedClient buildFeedClient(String appId, String appKey) throws URISyntaxException {
        FlexCredentials flexCredentials = new FlexCredentials(appId, appKey);
        JerseyClient jerseyClient = new JerseyClientBuilder().build();
        return new FeedClient(flexCredentials, flexBaseURL, jerseyClient);
    }

    public static void startAtLatest(FeedClient feedClient, FeedState feedState) {
        URI latestURI = feedClient.retrieveLatestItemURI();
        feedState.updateLastURI(latestURI);
        ScheduledExecutorService scheduledExecutorService = createExecutorService();
        FeedFollower feedFollower =
                new FeedFollower(feedClient, feedState, x->log.debug(x.toString()), BATCH_SIZE, scheduledExecutorService);
        feedFollower.start();
    }

    public static ScheduledExecutorService createExecutorService() {
        final AtomicInteger threadNum = new AtomicInteger();
        return Executors.newScheduledThreadPool(BATCH_SIZE, (runnable) -> new Thread(runnable, FeedFollower.class.getSimpleName() + "-retrieve-" + threadNum.incrementAndGet()));
    }

    private static void checkParameters(String... args) {
        if (args.length != 2) {
            log.error("arguments are Flex appId & appKey");
            throw new IllegalStateException("<appId> <appKey>");
        }
    }
}
