package com.flightstats.flex.client;

import com.flightstats.flex.domain.connections.ConnectionsResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import javax.ws.rs.core.UriBuilder;
import java.time.LocalDateTime;
import java.util.Map;

@Value
@Builder
@AllArgsConstructor
public class ConnectionsClient {
    public static final String INCLUDE_AIRPORTS = "includeAirports";
    public static final String EXCLUDE_AIRPORTS = "excludeAirports";
    public static final String INCLUDE_AIRLINES = "includeAirlines";
    public static final String EXCLUDE_AIRLINES = "excludeAirlines";
    public static final String NUM_HOURS = "numHours";
    public static final String MAX_CONNECTIONS = "maxConnections";
    public static final String INCLUDE_SURFACE = "includeSurface";
    public static final String PAYLOAD_TYPE = "payloadType";
    public static final String INCLUDE_CODESHARES = "includeCodeshares";
    public static final String INCLUDE_MULTIPLE_CARRIERS = "includeMultipleCarriers";
    public static final String MINIMUM_CONNECT_TIME = "minimumConnectTime";
    public static final String MAX_RESULTS = "maxResults";
    public enum PayloadType { passenger, cargo, both }

    private String appKey;
    private String appId;

    public ConnectionsResponse firstFlightIn(String departureAirport, String arrivalAirport, LocalDateTime date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/connections/rest/v1/json/firstflightin/%s/to/%s/arriving_before/%d/%d/%d/%d/%d",
                        departureAirport, arrivalAirport, date.getYear(), date.getMonthValue(), date.getDayOfMonth(), date.getHour(), date.getMinute()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), ConnectionsResponse.class);
    }

    public ConnectionsResponse firstFlightOut(String departureAirport, String arrivalAirport, LocalDateTime date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/connections/rest/v1/json/firstflightout/%s/to/%s/leaving_after/%d/%d/%d/%d/%d",
                        departureAirport, arrivalAirport, date.getYear(), date.getMonthValue(), date.getDayOfMonth(), date.getHour(), date.getMinute()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), ConnectionsResponse.class);
    }

    public ConnectionsResponse lastFlightIn(String departureAirport, String arrivalAirport, LocalDateTime date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/connections/rest/v1/json/lastflightin/%s/to/%s/arriving_before/%d/%d/%d/%d/%d",
                        departureAirport, arrivalAirport, date.getYear(), date.getMonthValue(), date.getDayOfMonth(), date.getHour(), date.getMinute()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), ConnectionsResponse.class);
    }

    public ConnectionsResponse lastFlightOut(String departureAirport, String arrivalAirport, LocalDateTime date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/connections/rest/v1/json/lastflightout/%s/to/%s/leaving_after/%d/%d/%d/%d/%d",
                        departureAirport, arrivalAirport, date.getYear(), date.getMonthValue(), date.getDayOfMonth(), date.getHour(), date.getMinute()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), ConnectionsResponse.class);
    }
}
