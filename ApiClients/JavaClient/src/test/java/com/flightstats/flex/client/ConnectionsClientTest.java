package com.flightstats.flex.client;


import com.flightstats.flex.FlexCredentials;
import com.flightstats.flex.domain.connections.ConnectionsResponse;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ConnectionsClientTest {

    //@Test
    public void testFirstFlightIn() {
        ConnectionsClient client = ConnectionsClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        params.put(ConnectionsClient.PAYLOAD_TYPE, ConnectionsClient.PayloadType.passenger.name());
        params.put(ConnectionsClient.MAX_RESULTS, "2");
        ConnectionsResponse response = client.firstFlightIn("PDX", "LHR", LocalDateTime.now().plusDays(1), params);
        System.out.println(response);
    }

    //@Test
    public void testFirstFlightOut() {
        ConnectionsClient client = ConnectionsClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        params.put(ConnectionsClient.PAYLOAD_TYPE, ConnectionsClient.PayloadType.passenger.name());
        params.put(ConnectionsClient.MAX_RESULTS, "2");
        ConnectionsResponse response = client.firstFlightOut("PDX", "LHR", LocalDateTime.now().plusDays(1), params);
        System.out.println(response);
    }

    //@Test
    public void testLastFlightIn() {
        ConnectionsClient client = ConnectionsClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        params.put(ConnectionsClient.PAYLOAD_TYPE, ConnectionsClient.PayloadType.passenger.name());
        params.put(ConnectionsClient.MAX_RESULTS, "2");
        ConnectionsResponse response = client.lastFlightIn("PDX", "LHR", LocalDateTime.now().plusDays(1), params);
        System.out.println(response);
    }

    //@Test
    public void testLastFlightOut() {
        ConnectionsClient client = ConnectionsClient.builder()
                .appId(FlexCredentials.appId)
                .appKey(FlexCredentials.appKey)
                .build();

        Map<String,String> params = new HashMap<>();
        params.put(ConnectionsClient.PAYLOAD_TYPE, ConnectionsClient.PayloadType.passenger.name());
        params.put(ConnectionsClient.MAX_RESULTS, "2");
        ConnectionsResponse response = client.lastFlightOut("PDX", "LHR", LocalDateTime.now().plusDays(1), params);
        System.out.println(response);
    }
}