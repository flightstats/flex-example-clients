package com.flightstats.flex.client;


import com.flightstats.flex.FlexCredentials;
import com.flightstats.flex.domain.flighttrack.FlightTrackResponse;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class FlightTrackClientTest {

    // @Test
    public void testFlightTrackById() {
        FlightTrackClient client = FlightTrackClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        // NOTE: You'll need to use the flight id of a current flight or this won't find a result.
        FlightTrackResponse response = client.byFlightId("694026942", new HashMap<>());
        System.out.println(response);
    }

    // @Test
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

    // @Test
    public void testFlightTrackByArrivingFlight() {
        FlightTrackClient client = FlightTrackClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        FlightTrackResponse response = client.byArrivingFlight(
                "AA", "100", LocalDate.now().minusDays(1), new HashMap<>());

        System.out.println(response);
    }
}