package com.flightstats.flex.client;

import com.flightstats.flex.domain.fids.FidsResponse;
import com.flightstats.flex.domain.flightstatus.FlightStatusResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import javax.ws.rs.core.UriBuilder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Value
@Builder
@AllArgsConstructor
public class FidsClient {
    public static final String REQUESTED_FIELDS = "requestedFields";

    private String appKey;
    private String appId;

    public FidsResponse byDepartingAirport(String airport, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/fids/rest/v1/json/%s/departures", airport),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), FidsResponse.class);
    }

    public FidsResponse byArrivalAirport(String airport, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/fids/rest/v1/json/%s/arrivals", airport),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), FidsResponse.class);
    }
}
