package com.flightstats.flex.client;


import com.flightstats.flex.FlexCredentials;
import com.flightstats.flex.domain.airportdelayindex.AirportDelayIndexResponse;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AirportDelayIndexClientTest {

    @Test
    public void byAirport() {
        AirportDelayIndexClient client = AirportDelayIndexClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirportDelayIndexResponse response = client.byAirport("PDX", params);
        System.out.println(response);
    }

    @Test
    public void byCountryCode() {
        AirportDelayIndexClient client = AirportDelayIndexClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirportDelayIndexResponse response = client.byCountry("GB", params);
        System.out.println(response);
    }

    @Test
    public void byRegion() {
        AirportDelayIndexClient client = AirportDelayIndexClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirportDelayIndexResponse response = client.byRegion("Caribbean", params);
        System.out.println(response);
    }

    @Test
    public void byState() {
        AirportDelayIndexClient client = AirportDelayIndexClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirportDelayIndexResponse response = client.byState("OR", params);
        System.out.println(response);
    }
}