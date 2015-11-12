package com.flightstats.flex.examples;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.flightstats.flex.examples.BigBoxRequest.createRequest;

/**
 * An example client that queries https://developer.flightstats.com/api-docs/flightstatus/v2/flightsNear.
 *
 * The official API is restricted to 5 degrees per side of the bounding box. This example client queries a much larger
 * bounding box by splitting it into multiple 5 degree requests, using multiple threads to optimize throughput.
 */
public class BigBoxSimpleMain {

    public static final String FLIGHTS_NEAR_API = "https://api.flightstats.com/flex/flightstatus/rest/v2/json/flightsNear/%s/%s/%s/%s?appId=%s&appKey=%s";

    /**
     * The parameters and ordering are:
     * 0 - appId
     * 1 - appKey
     * 2 - top latitude
     * 3 - left longitude
     * 4 - bottom latitude
     * 5 - right longitude
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        BigBoxRequest bigBoxBigBoxRequest = createRequest(args);
        List<String> smallBoxResponses = new BigBoxSimpleMain().execute(bigBoxBigBoxRequest, 5);
        System.out.println(String.join("\n", smallBoxResponses));
    }

    public List<String> execute(BigBoxRequest bigBoxBigBoxRequest, int threads) throws ExecutionException, InterruptedException {
        BigBoxFlightsNear bigBoxFlightsNear = new BigBoxFlightsNear(threads);
        return bigBoxFlightsNear.fetchAll(bigBoxBigBoxRequest);
    }
}
