package com.flightstats.flex.client;

import com.flightstats.flex.domain.ratings.RatingsResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import javax.ws.rs.core.UriBuilder;
import java.util.Map;

@Value
@Builder
@AllArgsConstructor
public class RatingsClient {
    private String appKey;
    private String appId;

    public RatingsResponse byFlight(String carrier, String flightNumber, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/ratings/rest/v1/json/flight/%s/%s", carrier, flightNumber),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), RatingsResponse.class);
    }

    public RatingsResponse byRoute(String departure, String arrival, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/ratings/rest/v1/json/route/%s/%s", departure, arrival),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), RatingsResponse.class);
    }
}
