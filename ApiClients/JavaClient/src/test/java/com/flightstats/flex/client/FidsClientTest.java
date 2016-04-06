package com.flightstats.flex.client;


import com.flightstats.flex.FlexCredentials;
import com.flightstats.flex.domain.fids.FidsEntry;
import com.flightstats.flex.domain.fids.FidsResponse;
import com.flightstats.flex.domain.flighttrack.FlightTrackResponse;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class FidsClientTest {

    //@Test
    public void testByDepartingAirport() {
        FidsClient client = FidsClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        params.put(FidsClient.REQUESTED_FIELDS, FidsEntry.ALL_FIELDS);
        FidsResponse response = client.byDepartingAirport("PDX", params);
        System.out.println(response);
    }

    //@Test
    public void testByArrivalAirport() {
        FidsClient client = FidsClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        params.put(FidsClient.REQUESTED_FIELDS, FidsEntry.ALL_FIELDS);
        FidsResponse response = client.byArrivalAirport("PDX", params);
        System.out.println(response);
    }
}