package com.flightstats.flex.client;


import com.flightstats.flex.FlexCredentials;
import com.flightstats.flex.domain.connections.ConnectionsResponse;
import com.flightstats.flex.domain.delayindex.DelayIndexResponse;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class DelayIndexClientTest {

    @Test
    public void byAirport() {
        DelayIndexClient client = DelayIndexClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        DelayIndexResponse response = client.byAirport("PDX", params);
        System.out.println(response);
    }

    @Test
    public void byCountryCode() {
        DelayIndexClient client = DelayIndexClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        DelayIndexResponse response = client.byCountry("GB", params);
        System.out.println(response);
    }

    @Test
    public void byRegion() {
        DelayIndexClient client = DelayIndexClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        DelayIndexResponse response = client.byRegion("Caribbean", params);
        System.out.println(response);
    }

    @Test
    public void byState() {
        DelayIndexClient client = DelayIndexClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        DelayIndexResponse response = client.byState("OR", params);
        System.out.println(response);
    }
}