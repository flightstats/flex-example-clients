package com.flightstats.flex.flightstatusfeed.client.util;

import com.google.common.collect.Iterables;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Slf4j
public class FeedFollower {

    private static final int DELAY = 5;

    private final int batchSize;
    private final FeedState feedState;
    private final FeedClient feedClient;
    private final ItemProcessor itemProcessor;
    private final ScheduledExecutorService scheduledExecutorService;
    private final AtomicReference<ScheduledFuture<?>> scheduledFuture = new AtomicReference<>();

    public FeedFollower(FeedClient feedClient, FeedState feedState, ItemProcessor itemProcessor, int batchSize, ScheduledExecutorService scheduledExecutorService) {
        this.feedClient = feedClient;
        this.feedState = feedState;
        this.batchSize = batchSize;
        this.itemProcessor = itemProcessor;
        this.scheduledExecutorService = scheduledExecutorService;
    }

    public void start() {
        if (scheduledFuture.get() != null) {
            throw new IllegalStateException("already started");
        }
        ScheduledFuture<?> justScheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this::fetchAvailableBatches, 0, DELAY, TimeUnit.SECONDS);
        scheduledFuture.set(justScheduledFuture);
    }

    public void stop() {
        ScheduledFuture<?> maybeScheduledFuture = scheduledFuture.get();
        if (maybeScheduledFuture != null) {
            maybeScheduledFuture.cancel(true);
        }
    }

    private void fetchAvailableBatches() {
        try {
            while (true) {
                if (0 == fetchNextBatch()) {
                    break;
                }
            }
        } catch (Exception exception) {
            log.error("Encountered an exception fetching next batch", exception);
        }
    }

    private int fetchNextBatch() {
        Optional<URI> lastProcessedURI = feedState.retrieveLastURI();
        if (!lastProcessedURI.isPresent()) {
            throw new IllegalStateException("feedState doesn't know the previous URI");
        }

        List<URI> subsequentURIs = feedClient.retrieveItemURIsAfter(lastProcessedURI.get(), batchSize);
        if (subsequentURIs.size() == 0) {
            return 0;
        }

        List<Future<?>> futures =
                subsequentURIs
                        .stream()
                        .map(this::scheduleURIForRetrieval)
                        .collect(Collectors.toList());
        handleFetchFutures(futures);
        feedState.updateLastURI(Iterables.getLast(subsequentURIs));
        return subsequentURIs.size();
    }

    private Future<?> scheduleURIForRetrieval(URI uri) {
        return scheduledExecutorService.submit(() -> retrieveAndProcessItem(uri));
    }

    private void handleFetchFutures(List<Future<?>> futures) {
        Exception caught = null;
        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (Exception exception) {
                log.error("Encountered an exception fetching or processing a feed item. One exceptionf from this batch will be propagated", exception);
                caught = exception;
            }
        }
        if (caught != null) {
            throw new RuntimeException("caught at least once exception fetching or processing a feed items", caught);
        }
    }

    private void retrieveAndProcessItem(URI uri) {
        JsonObject jsonObject = feedClient.retrieveItemAsGson(uri);
        itemProcessor.process(jsonObject);
    }
}
