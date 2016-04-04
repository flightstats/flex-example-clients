package com.flightstats.flex.client;


import com.flightstats.flex.FlexCredentials;
import com.flightstats.flex.domain.flightstatus.FlightStatusResponse;
import org.junit.Test;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

public class FlightStatusClientTest {

    // @Test
    public void testFlightStatusById() {
        FlightStatusClient client = FlightStatusClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        // NOTE: You'll need to use the flight id of a current flight or this won't find a result.
        Map<String,String> params = new HashMap<>();
        params.put(FlexHelper.EXTENDED_OPTIONS, FlexHelper.INCLUDE_NEW_FIELDS);
        FlightStatusResponse response = client.byFlightId("694026942", params);
        System.out.println(response);
    }

    //@Test
    public void testFlightStatusByDepartingFlight() {
        FlightStatusClient client = FlightStatusClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        FlightStatusResponse response = client.byDepartingFlight(
                "AA", "100", LocalDate.now(), new HashMap<>());

        System.out.println(response);
    }

    // @Test
    public void testFlightStatusByArrivingFlight() {
        FlightStatusClient client = FlightStatusClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        FlightStatusResponse response = client.byArrivingFlight(
                "AA", "100", LocalDate.now(), new HashMap<>());

        System.out.println(response);
    }

    // @Test
    public void testFlightStatusByDepartureAirport() {
        FlightStatusClient client = FlightStatusClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        FlightStatusResponse response = client.byDepartureAirport(
                "PDX", ZonedDateTime.now(), new HashMap<>());

        System.out.println(response);
    }

    // @Test
    public void testFlightStatusByArrivalAirport() {
        FlightStatusClient client = FlightStatusClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        FlightStatusResponse response = client.byArrivalAirport(
                "PDX", ZonedDateTime.now(), new HashMap<>());

        System.out.println(response);
    }
}