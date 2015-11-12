package com.flightstats.flex.examples;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Try a big box query with different threading levels.
 */
public class BigBoxPerfTestMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] threadLevels = { 5, 10, 15, 20};
        for (int threadLevel : threadLevels) {
            long startTime = System.currentTimeMillis();
            List<String> smallBoxResponses = new BigBoxSimpleMain().execute(BigBoxRequest.createRequest(args), threadLevel);
            System.out.println(threadLevel + " threads execution time (millis): " + (System.currentTimeMillis() - startTime));
        }
    }
}
