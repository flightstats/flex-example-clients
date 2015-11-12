package com.flightstats.flex.examples;

public class BigBoxRequest {
    String appId;
    String appKey;
    int topLatitude;
    int leftLongitude;
    int bottomLatitude;
    int rightLongitude;

    public BigBoxRequest(String appId, String appKey, int topLatitude, int leftLongitude, int bottomLatitude, int rightLongitude) {
        this.appId = appId;
        this.appKey = appKey;
        this.topLatitude = topLatitude;
        this.leftLongitude = leftLongitude;
        this.bottomLatitude = bottomLatitude;
        this.rightLongitude = rightLongitude;
    }

    public static BigBoxRequest createRequest(String[] args) {
        if (args.length < 6) {
            System.out.println("Incorrect number of parameters:");
            printUsage();
        }

        try {
            BigBoxRequest bigBoxRequest = new BigBoxRequest(
                    args[0], args[1],
                    Integer.parseInt(args[2]), Integer.parseInt(args[3]),
                    Integer.parseInt(args[4]), Integer.parseInt(args[5]));
            if (bigBoxRequest.topLatitude <= bigBoxRequest.bottomLatitude) {
                System.out.println("top latitude must be greater than bottom latitude");
                printUsage();
            }
            if (bigBoxRequest.rightLongitude <= bigBoxRequest.leftLongitude) {
                System.out.println("right longitude must be greater than left longitude");
                printUsage();
            }
            return bigBoxRequest;
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
}
