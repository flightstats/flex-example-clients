package com.flightstats.flex.client;


import com.flightstats.flex.FlexCredentials;
import com.flightstats.flex.domain.flighttrack.FlightTrackResponse;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class FlightTrackClientTest {

    //@Test
    public void testFlightTrackById() {
        FlightTrackClient client = FlightTrackClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        // NOTE: You'll need to use the flight id of a current flight or this won't find a result.
        FlightTrackResponse response = client.byFlightId("694026942", new HashMap<>());
        System.out.println(response);
    }

    //@Test
    public void testFlightTrackByDepartingFlight() {
        FlightTrackClient client = FlightTrackClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        params.put(FlexHelper.EXTENDED_OPTIONS, FlexHelper.INCLUDE_NEW_FIELDS);
        FlightTrackResponse response = client.byDepartingFlight(
                "AA", "100", LocalDate.now().minusDays(1), params);

        System.out.println(response);
    }

    //@Test
    public void testFlightTrackByArrivingFlight() {
        FlightTrackClient client = FlightTrackClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        FlightTrackResponse response = client.byArrivingFlight(
                "AA", "100", LocalDate.now().minusDays(1), new HashMap<>());

        System.out.println(response);
    }

    //@Test
    public void testFlightTrackByDepartureAirport() {
        FlightTrackClient client = FlightTrackClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        FlightTrackResponse response = client.byDepartureAirport(
                "PDX", new HashMap<>());

        System.out.println(response);
    }

    //@Test
    public void testFlightTrackByArrivalAirport() {
        FlightTrackClient client = FlightTrackClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        FlightTrackResponse response = client.byArrivalAirport(
                "PDX", new HashMap<>());

        System.out.println(response);
    }

    //@Test
    public void testFlightPositionsByBoundingBox() {
        FlightTrackClient client = FlightTrackClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        FlightTrackResponse response = client.byBoundingBox(45, -125, 40, -120, new HashMap<>());

        System.out.println(response);
    }

    //@Test
    public void testFlightPositionsByRadius() {
        FlightTrackClient client = FlightTrackClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        FlightTrackResponse response = client.byRadius(45, -122, 25, new HashMap<>());

        System.out.println(response);
    }
}