package com.flightstats.flex.client;


import com.flightstats.flex.FlexCredentials;
import com.flightstats.flex.domain.flightstatus.FlightStatusResponse;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class HistoricalFlightStatusClientTest {

    //@Test
    public void testFlightStatusById() {
        HistoricalFlightStatusClient client = HistoricalFlightStatusClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        // NOTE: You'll need to use the flight id of a historical flight or this won't find a result.
        Map<String,String> params = new HashMap<>();
        params.put(FlexHelper.EXTENDED_OPTIONS, FlexHelper.EXCLUDE_APPENDIX + "," + FlexHelper.INCLUDE_DELTAS);
        FlightStatusResponse response = client.byFlightId("679757280", params);
        System.out.println(response);
    }

    //@Test
    public void testFlightStatusByDepartingFlight() {
        HistoricalFlightStatusClient client = HistoricalFlightStatusClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        FlightStatusResponse response = client.byDepartingFlight("AA", "100", LocalDate.now(), new HashMap<>());

        System.out.println(response);
    }

    //@Test
    public void testFlightStatusByArrivingFlight() {
        HistoricalFlightStatusClient client = HistoricalFlightStatusClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        FlightStatusResponse response = client.byArrivingFlight("AA", "100", LocalDate.now(), new HashMap<>());

        System.out.println(response);
    }

    //@Test
    public void testFlightStatusByDepartureAirport() {
        HistoricalFlightStatusClient client = HistoricalFlightStatusClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        FlightStatusResponse response = client.byDepartureAirport("PDX", LocalDateTime.now(), new HashMap<>());

        System.out.println(response);
    }

    //@Test
    public void testFlightStatusByArrivalAirport() {
        HistoricalFlightStatusClient client = HistoricalFlightStatusClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        FlightStatusResponse response = client.byArrivalAirport("PDX", LocalDateTime.now(), new HashMap<>());

        System.out.println(response);
    }

    //@Test
    public void testFlightStatusByRouteDeparture() {
        HistoricalFlightStatusClient client = HistoricalFlightStatusClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        FlightStatusResponse response = client.byRouteDeparture("PDX", "SFO", LocalDate.now(), new HashMap<>());

        System.out.println(response);
    }

    //@Test
    public void testFlightStatusByRouteArrival() {
        HistoricalFlightStatusClient client = HistoricalFlightStatusClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        FlightStatusResponse response = client.byRouteArrival("PDX", "SFO", LocalDate.now(), new HashMap<>());

        System.out.println(response);
    }
}