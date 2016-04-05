package com.flightstats.flex.client;


import com.flightstats.flex.FlexCredentials;
import com.flightstats.flex.domain.flightstatus.FlightStatusResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CurrentFlightStatusClientTest {

    // @Test
    public void testFlightStatusById() {
        CurrentFlightStatusClient client = CurrentFlightStatusClient.builder()
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
        CurrentFlightStatusClient client = CurrentFlightStatusClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        FlightStatusResponse response = client.byDepartingFlight("AA", "100", LocalDate.now(), new HashMap<>());

        System.out.println(response);
    }

    // @Test
    public void testFlightStatusByArrivingFlight() {
        CurrentFlightStatusClient client = CurrentFlightStatusClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        FlightStatusResponse response = client.byArrivingFlight("AA", "100", LocalDate.now(), new HashMap<>());

        System.out.println(response);
    }

    // @Test
    public void testFlightStatusByDepartureAirport() {
        CurrentFlightStatusClient client = CurrentFlightStatusClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        FlightStatusResponse response = client.byDepartureAirport("PDX", LocalDateTime.now(), new HashMap<>());

        System.out.println(response);
    }

    // @Test
    public void testFlightStatusByArrivalAirport() {
        CurrentFlightStatusClient client = CurrentFlightStatusClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        FlightStatusResponse response = client.byArrivalAirport("PDX", LocalDateTime.now(), new HashMap<>());

        System.out.println(response);
    }

    // @Test
    public void testFlightStatusByRouteDeparture() {
        CurrentFlightStatusClient client = CurrentFlightStatusClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        FlightStatusResponse response = client.byRouteDeparture("PDX", "SFO", LocalDate.now(), new HashMap<>());

        System.out.println(response);
    }

    // @Test
    public void testFlightStatusByRouteArrival() {
        CurrentFlightStatusClient client = CurrentFlightStatusClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        FlightStatusResponse response = client.byRouteArrival("PDX", "SFO", LocalDate.now(), new HashMap<>());

        System.out.println(response);
    }
}