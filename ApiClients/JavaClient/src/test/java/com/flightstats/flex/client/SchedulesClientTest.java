package com.flightstats.flex.client;


import com.flightstats.flex.FlexCredentials;
import com.flightstats.flex.domain.schedules.SchedulesResponse;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;

public class SchedulesClientTest {

    //@Test
    public void testByCarrierAndFlightDepartingOnDate() {
        SchedulesClient client = SchedulesClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        params.put(FlexHelper.EXTENDED_OPTIONS, FlexHelper.INCLUDE_NEW_FIELDS);
        SchedulesResponse response = client.byCarrierAndFlightDepartingOnDate("AA", "100", LocalDate.now(), params);
        System.out.println(response);
    }

    //@Test
    public void testByCarrierAndFlightArrivingOnDate() {
        SchedulesClient client = SchedulesClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        params.put(FlexHelper.EXTENDED_OPTIONS, FlexHelper.INCLUDE_NEW_FIELDS);
        SchedulesResponse response = client.byCarrierAndFlightArrivingOnDate("AA", "100", LocalDate.now(), params);
        System.out.println(response);
    }

    //@Test
    public void testByRouteDepartingOnDate() {
        SchedulesClient client = SchedulesClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        params.put(FlexHelper.EXTENDED_OPTIONS, FlexHelper.INCLUDE_NEW_FIELDS);
        SchedulesResponse response = client.byRouteDepartingOnDate("PDX", "SFO", LocalDate.now(), params);
        System.out.println(response);
    }

    //@Test
    public void testByRouteArrivingOnDate() {
        SchedulesClient client = SchedulesClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        params.put(FlexHelper.EXTENDED_OPTIONS, FlexHelper.INCLUDE_NEW_FIELDS);
        SchedulesResponse response = client.byRouteArrivingOnDate("PDX", "SFO", LocalDate.now(), params);
        System.out.println(response);
    }

    //@Test
    public void byAirportDepartingOnDate() {
        SchedulesClient client = SchedulesClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        params.put(FlexHelper.EXTENDED_OPTIONS, FlexHelper.INCLUDE_NEW_FIELDS);
        SchedulesResponse response = client.byAirportDepartingOnDate("PDX", LocalDateTime.now(), params);
        System.out.println(response);
    }

    //@Test
    public void byAirportArrivingOnDate() {
        SchedulesClient client = SchedulesClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        params.put(FlexHelper.EXTENDED_OPTIONS, FlexHelper.INCLUDE_NEW_FIELDS);
        SchedulesResponse response = client.byAirportArrivingOnDate("PDX", LocalDateTime.now(), params);
        System.out.println(response);
    }
}