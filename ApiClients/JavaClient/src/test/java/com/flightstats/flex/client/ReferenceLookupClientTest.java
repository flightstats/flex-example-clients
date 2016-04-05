package com.flightstats.flex.client;


import com.flightstats.flex.FlexCredentials;
import com.flightstats.flex.domain.reference.AirlinesLookupResponse;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ReferenceLookupClientTest {

    @Test
    public void testAirlinesAll() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirlinesLookupResponse response = client.airlinesAll(params);
        System.out.println(response);
    }

    @Test
    public void testAirlinesActive() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirlinesLookupResponse response = client.airlinesActive(params);
        System.out.println(response);
    }

    @Test
    public void testAirlinesActiveForDate() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirlinesLookupResponse response = client.airlinesActiveForDate(LocalDate.now(), params);
        System.out.println(response);
    }

    @Test
    public void testAirlinesByFsCode() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirlinesLookupResponse response = client.airlinesByFsCode("AA", params);
        System.out.println(response);
    }

    @Test
    public void testAirlinesByIataCode() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirlinesLookupResponse response = client.airlinesByIataCode("AA", params);
        System.out.println(response);
    }

    @Test
    public void testAirlinesByIataCodeOnDate() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirlinesLookupResponse response = client.airlinesByIataCodeOnDate("AA", LocalDate.now(), params);
        System.out.println(response);
    }

    @Test
    public void testAirlinesByIcaoCode() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirlinesLookupResponse response = client.airlinesByIcaoCode("AAL", params);
        System.out.println(response);
    }

    @Test
    public void testAirlinesByIcaoCodeOnDate() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirlinesLookupResponse response = client.airlinesByIcaoCodeOnDate("AAL", LocalDate.now(), params);
        System.out.println(response);
    }
}