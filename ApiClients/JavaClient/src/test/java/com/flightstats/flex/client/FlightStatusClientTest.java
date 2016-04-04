package com.flightstats.flex.client;


import com.flightstats.flex.FlexCredentials;
import com.flightstats.flex.domain.flightstatus.FlightStatusByFlightResponse;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;

public class FlightStatusClientTest {

    // @Test
    public void testFlightStatusById() {
        FlightStatusClient client = FlightStatusClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        // NOTE: You'll need to use the flight id of a current flight or this won't find a result.
        FlightStatusByFlightResponse response = client.byFlightId("694026942", new HashMap<String, String>());
        System.out.println(response);
    }

    //@Test
    public void testFlightStatusByDepartingFlight() {
        FlightStatusClient client = FlightStatusClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        FlightStatusByFlightResponse response = client.byDepartingFlight(
                "AA", "100", LocalDate.now(), new HashMap<String, String>());

        System.out.println(response);
    }

    @Test
    public void testFlightStatusByArrivingFlight() {
        FlightStatusClient client = FlightStatusClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        FlightStatusByFlightResponse response = client.byArrivingFlight(
                "AA", "100", LocalDate.now(), new HashMap<String, String>());

        System.out.println(response);
    }
}