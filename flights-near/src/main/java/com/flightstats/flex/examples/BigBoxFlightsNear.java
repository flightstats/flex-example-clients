package com.flightstats.flex.examples;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class BigBoxFlightsNear {
    private final ForkJoinPool fetchPool;
    private final Client httpClient = ClientBuilder.newClient();

    BigBoxFlightsNear(int threads) {
        fetchPool = (ForkJoinPool) Executors.newWorkStealingPool(threads);
    }

    /**
     * Breaks the request into smaller, API compatible, bounding boxes and fetch the data for each.
     */
    public List<String> fetchAll(BigBoxRequest bigBoxRequest) throws ExecutionException, InterruptedException {
        List<BigBoxRequest> smallBoxBigBoxRequests = createSmallBoxRequests(bigBoxRequest);
        return fetchPool.submit(() ->
                smallBoxBigBoxRequests.parallelStream()
                        .map(this::fetchSmallBoundingBox)
                        .collect(Collectors.toList())).get();
    }

    private List<BigBoxRequest> createSmallBoxRequests(BigBoxRequest bigBoxRequest) {
        List<BigBoxRequest> bigBoxRequests = new ArrayList<>();
        for (int bottomLatitude = bigBoxRequest.bottomLatitude; bottomLatitude < bigBoxRequest.topLatitude; bottomLatitude += 5) {
            for (int leftLongitude = bigBoxRequest.leftLongitude; leftLongitude < bigBoxRequest.rightLongitude; leftLongitude += 5) {
                int topLatitude = Math.min(bottomLatitude + 5, bigBoxRequest.topLatitude);
                int rightLongitude = Math.min(leftLongitude + 5, bigBoxRequest.rightLongitude);
                BigBoxRequest smallBoxBigBoxRequest = new BigBoxRequest(
                        bigBoxRequest.appId, bigBoxRequest.appKey,
                        topLatitude, leftLongitude,
                        bottomLatitude, rightLongitude);
                bigBoxRequests.add(smallBoxBigBoxRequest);
            }
        }
        return bigBoxRequests;
    }

    private String fetchSmallBoundingBox(BigBoxRequest bigBoxRequest) {
        String target = String.format(BigBoxSimpleMain.FLIGHTS_NEAR_API,
                bigBoxRequest.topLatitude, bigBoxRequest.leftLongitude,
                bigBoxRequest.bottomLatitude, bigBoxRequest.rightLongitude,
                bigBoxRequest.appId, bigBoxRequest.appKey);
        return httpClient.target(target).request(MediaType.APPLICATION_JSON).get(String.class);
    }
}
