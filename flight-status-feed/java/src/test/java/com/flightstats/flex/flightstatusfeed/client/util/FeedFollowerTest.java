package com.flightstats.flex.flightstatusfeed.client.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;

import java.net.URI;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class FeedFollowerTest {

    private static final String SIMPLE_JSON_TEXT = "{\"variable\": 1234}";

    private final Gson gson = new Gson();
    private final JsonObject SIMPLE_JSON = gson.fromJson(SIMPLE_JSON_TEXT, JsonObject.class);

    @Test
    public void testStart() {

        FeedClient feedClient = Mockito.mock(FeedClient.class);
        FeedState feedState = new FeedStateInMemory();
        ItemProcessor itemProcessor = Mockito.mock(ItemProcessor.class);
        ScheduledExecutorService scheduledExecutorService = Mockito.mock(ScheduledExecutorService.class);

        // When the scheduled task is submitted, invoke the runnable exactly once
        Mockito.when(scheduledExecutorService.scheduleWithFixedDelay(Matchers.any(Runnable.class), Matchers.anyInt(), Matchers.anyInt(), Matchers.any(TimeUnit.class)))
                .thenAnswer(this::inlineScheduleWithFixedDelay);
        Mockito.when(scheduledExecutorService.submit(Matchers.any(Runnable.class)))
                .thenAnswer(this::inlineSubmit);

        feedState.updateLastURI(URI.create("http://foo/1"));

        Mockito.when(feedClient.retrieveItemURIsAfter(Matchers.any(URI.class), Matchers.anyInt()))
                .thenReturn(Collections.singletonList(URI.create("http://foo/2")))
                .thenReturn(Collections.emptyList());
        Mockito.when(feedClient.retrieveItemAsGson(Matchers.any(URI.class))).thenReturn(SIMPLE_JSON);

        FeedFollower feedFollower = new FeedFollower(feedClient, feedState, itemProcessor, 1, scheduledExecutorService);
        feedFollower.start();

        Mockito.verify(feedClient).retrieveItemURIsAfter(URI.create("http://foo/1"), 1);
        Mockito.verify(feedClient).retrieveItemURIsAfter(URI.create("http://foo/2"), 1);
        Mockito.verify(feedClient).retrieveItemAsGson(URI.create("http://foo/2"));
        Mockito.verifyNoMoreInteractions(feedClient);

        Mockito.verify(itemProcessor).process(SIMPLE_JSON);
        Mockito.verifyNoMoreInteractions(itemProcessor);
    }

    private Object inlineSubmit(InvocationOnMock invocationOnMock) {
        Runnable runnable = (Runnable) invocationOnMock.getArguments()[0];
        runnable.run();
        return Mockito.mock(ScheduledFuture.class);
    }

    private Object inlineScheduleWithFixedDelay(InvocationOnMock invocationOnMock) {
        Runnable runnable = (Runnable) invocationOnMock.getArguments()[0];
        runnable.run();
        return Mockito.mock(ScheduledFuture.class);
    }
}