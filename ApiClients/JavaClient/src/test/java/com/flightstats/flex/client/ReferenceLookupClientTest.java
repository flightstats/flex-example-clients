package com.flightstats.flex.client;


import com.flightstats.flex.FlexCredentials;
import com.flightstats.flex.domain.reference.AirlinesLookupResponse;
import com.flightstats.flex.domain.reference.AirportsLookupResponse;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ReferenceLookupClientTest {

    // Airlines
    //@Test
    public void testAirlinesAll() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirlinesLookupResponse response = client.airlinesAll(params);
        System.out.println(response);
    }

    //@Test
    public void testAirlinesActive() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirlinesLookupResponse response = client.airlinesActive(params);
        System.out.println(response);
    }

    //@Test
    public void testAirlinesActiveForDate() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirlinesLookupResponse response = client.airlinesActiveForDate(LocalDate.now(), params);
        System.out.println(response);
    }

    //@Test
    public void testAirlinesByFsCode() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirlinesLookupResponse response = client.airlinesByFsCode("AA", params);
        System.out.println(response);
    }

    //@Test
    public void testAirlinesByIataCode() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirlinesLookupResponse response = client.airlinesByIataCode("AA", params);
        System.out.println(response);
    }

    //@Test
    public void testAirlinesByIataCodeOnDate() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirlinesLookupResponse response = client.airlinesByIataCodeOnDate("AA", LocalDate.now(), params);
        System.out.println(response);
    }

    //@Test
    public void testAirlinesByIcaoCode() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirlinesLookupResponse response = client.airlinesByIcaoCode("AAL", params);
        System.out.println(response);
    }

    //@Test
    public void testAirlinesByIcaoCodeOnDate() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirlinesLookupResponse response = client.airlinesByIcaoCodeOnDate("AAL", LocalDate.now(), params);
        System.out.println(response);
    }

    // Airports
    //@Test
    public void testAirportsActive() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirportsLookupResponse response = client.airportsActive(params);
        System.out.println(response);
    }

    //@Test
    public void testAirportsAll() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirportsLookupResponse response = client.airportsAll(params);
        System.out.println(response);
    }

    //@Test
    public void testAirportsActiveForDate() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirportsLookupResponse response = client.airportsActiveForDate(LocalDate.now(), params);
        System.out.println(response);
    }

    //@Test
    public void testAirportsByCodeToday() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirportsLookupResponse response = client.airportsByCodeToday("PDX", params);
        System.out.println(response);
    }

    //@Test
    public void testAirportsByCodeOnDate() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirportsLookupResponse response = client.airportsByCodeOnDate("PDX", LocalDate.now(), params);
        System.out.println(response);
    }

    //@Test
    public void testAirportsByCityCode() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirportsLookupResponse response = client.airportsByCityCode("ABC", params);
        System.out.println(response);
    }

    //@Test
    public void testAirportsByCountryCode() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirportsLookupResponse response = client.airportsByCountryCode("GB", params);
        System.out.println(response);
    }

    //@Test
    public void testAirportsByFsCode() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirportsLookupResponse response = client.airportsByFsCode("PDX", params);
        System.out.println(response);
    }

    //@Test
    public void testAirportsByIataCode() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirportsLookupResponse response = client.airportsByIataCode("PDX", params);
        System.out.println(response);
    }

    //@Test
    public void testAirportsByIataCodeOnDate() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirportsLookupResponse response = client.airportsByIataCodeOnDate("PDX", LocalDate.now(), params);
        System.out.println(response);
    }

    //@Test
    public void testAirportsByIcaoCode() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirportsLookupResponse response = client.airportsByIcaoCode("KPDX", params);
        System.out.println(response);
    }

    //@Test
    public void testAirportsByIcaoCodeOnDate() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirportsLookupResponse response = client.airportsByIcaoCodeOnDate("KPDX", LocalDate.now(), params);
        System.out.println(response);
    }

    //@Test
    public void testAirportsWithinRadius() {
        ReferenceLookupClient client = ReferenceLookupClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        AirportsLookupResponse response = client.airportsWithinRadius(17, 39, 150, params);
        System.out.println(response);
    }
}