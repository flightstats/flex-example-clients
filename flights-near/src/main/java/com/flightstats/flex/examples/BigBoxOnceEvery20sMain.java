package com.flightstats.flex.examples;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Try a big box query with different threading levels.
 */
public class BigBoxOnceEvery20sMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int threadLevel = Integer.parseInt(args[6]);
        BigBoxRequest bigBoxRequest = BigBoxRequest.createRequest(args);
        BigBoxFlightsNear bigBoxFlightsNear = new BigBoxFlightsNear(threadLevel);
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(() -> fetchPositions(bigBoxFlightsNear, bigBoxRequest), 0, 20, TimeUnit.SECONDS);
    }

    public static void fetchPositions(BigBoxFlightsNear bigBoxFlightsNear, BigBoxRequest bigBoxRequest) {
        try {
            long startTime = System.currentTimeMillis();
            List<String> smallBoxResponses = bigBoxFlightsNear.fetchAll(bigBoxRequest);
            System.out.println(String.format(" fetched %s small boxes in %s milliseconds", smallBoxResponses.size(), System.currentTimeMillis() - startTime));
        } catch (Exception exception) {
            throw new IllegalStateException("encounted unexpected exception", exception);
        }
    }
}
