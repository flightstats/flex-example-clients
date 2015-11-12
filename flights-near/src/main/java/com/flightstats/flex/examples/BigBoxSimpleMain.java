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
        Request bigBoxRequest = createRequest(args);
        List<String> smallBoxResponses = new BigBoxSimpleMain().execute(bigBoxRequest, 5);
        System.out.println(String.join("\n", smallBoxResponses));
    }

    public List<String> execute(Request bigBoxRequest, int threads) throws ExecutionException, InterruptedException {
        BigBoxFlightsNear bigBoxFlightsNear = new BigBoxFlightsNear(threads);
        return bigBoxFlightsNear.fetchAll(bigBoxRequest);
    }

    public static Request createRequest(String[] args) {
        if (args.length < 6) {
            System.out.println("Incorrect number of parameters:");
            printUsage();
        }

        try {
            Request request = new Request(
                    args[0], args[1],
                    Integer.parseInt(args[2]), Integer.parseInt(args[3]),
                    Integer.parseInt(args[4]), Integer.parseInt(args[5]));
            if (request.topLatitude <= request.bottomLatitude) {
                System.out.println("top latitude must be greater than bottom latitude");
                printUsage();
            }
            if (request.rightLongitude <= request.leftLongitude) {
                System.out.println("right longitude must be greater than left longitude");
                printUsage();
            }
            return request;
        } catch (NumberFormatException e) {
            System.out.println("Coordinates must be integers - " + e.getMessage());
            printUsage();
        }
        return null;
    }

    private static void printUsage() {
        System.out.println("FlightsNear appId appKey top_latitude left_longitude bottom_latitude right_longitude");
        System.exit(-1);
    }

    public static class BigBoxFlightsNear {
        private final ForkJoinPool fetchPool;
        private final Client httpClient = ClientBuilder.newClient();

        BigBoxFlightsNear(int threads) {
            fetchPool = (ForkJoinPool) Executors.newWorkStealingPool(threads);
        }

        /**
         * Breaks the request into smaller, API compatible, bounding boxes and fetch the data for each.
         */
        private List<String> fetchAll(Request bigBoxRequest) throws ExecutionException, InterruptedException {
            List<Request> smallBoxRequests = createSmallBoxRequests(bigBoxRequest);
            return fetchPool.submit(() ->
                    smallBoxRequests.parallelStream()
                            .map(this::fetchSmallBoundingBox)
                            .collect(Collectors.toList())).get();
        }

        private List<Request> createSmallBoxRequests(Request bigBoxRequest) {
            List<Request> requests = new ArrayList<>();
            for (int bottomLatitude = bigBoxRequest.bottomLatitude; bottomLatitude < bigBoxRequest.topLatitude; bottomLatitude += 5) {
                for (int leftLongitude = bigBoxRequest.leftLongitude; leftLongitude < bigBoxRequest.rightLongitude; leftLongitude += 5) {
                    int topLatitude = Math.min(bottomLatitude + 5, bigBoxRequest.topLatitude);
                    int rightLongitude = Math.min(leftLongitude + 5, bigBoxRequest.rightLongitude);
                    Request smallBoxRequest = new Request(
                            bigBoxRequest.appId, bigBoxRequest.appKey,
                            topLatitude, leftLongitude,
                            bottomLatitude, rightLongitude);
                    requests.add(smallBoxRequest);
                }
            }
            return requests;
        }

        private String fetchSmallBoundingBox(Request request) {
            String target = String.format(FLIGHTS_NEAR_API,
                    request.topLatitude, request.leftLongitude,
                    request.bottomLatitude, request.rightLongitude,
                    request.appId, request.appKey);
            return httpClient.target(target).request(MediaType.APPLICATION_JSON).get(String.class);
        }
    }

    public static class Request {
        String appId;
        String appKey;
        int topLatitude;
        int leftLongitude;
        int bottomLatitude;
        int rightLongitude;

        public Request(String appId, String appKey, int topLatitude, int leftLongitude, int bottomLatitude, int rightLongitude) {
            this.appId = appId;
            this.appKey = appKey;
            this.topLatitude = topLatitude;
            this.leftLongitude = leftLongitude;
            this.bottomLatitude = bottomLatitude;
            this.rightLongitude = rightLongitude;
        }
    }
}
