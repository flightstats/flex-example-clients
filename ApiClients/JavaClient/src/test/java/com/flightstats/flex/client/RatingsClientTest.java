package com.flightstats.flex.client;


import com.flightstats.flex.FlexCredentials;
import com.flightstats.flex.domain.ratings.RatingsResponse;
import com.flightstats.flex.domain.schedules.SchedulesResponse;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class RatingsClientTest {

    //@Test
    public void testByFlight() {
        RatingsClient client = RatingsClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        RatingsResponse response = client.byFlight("HA", "25", params);
        System.out.println(response);
    }

    //@Test
    public void testByRoute() {
        RatingsClient client = RatingsClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        RatingsResponse response = client.byRoute("PDX", "HNL", params);
        System.out.println(response);
    }
}