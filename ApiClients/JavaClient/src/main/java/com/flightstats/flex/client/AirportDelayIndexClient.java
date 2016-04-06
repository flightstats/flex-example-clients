package com.flightstats.flex.client;

import com.flightstats.flex.domain.airportdelayindex.AirportDelayIndexResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import javax.ws.rs.core.UriBuilder;
import java.util.Map;

@Value
@Builder
@AllArgsConstructor
public class AirportDelayIndexClient {
    public static final String CODE_TYPE = "codeType";
    public static final String CLASSIFICATION = "classification";
    public static final String SCORE = "score";

    private String appKey;
    private String appId;

    public AirportDelayIndexResponse byAirport(String airport, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/delayindex/rest/v1/json/airports/%s", airport),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), AirportDelayIndexResponse.class);
    }

    public AirportDelayIndexResponse byCountry(String countryCode, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/delayindex/rest/v1/json/country/%s", countryCode),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), AirportDelayIndexResponse.class);
    }

    public AirportDelayIndexResponse byRegion(String region, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/delayindex/rest/v1/json/region/%s", region),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), AirportDelayIndexResponse.class);
    }

    public AirportDelayIndexResponse byState(String state, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/delayindex/rest/v1/json/state/%s", state),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), AirportDelayIndexResponse.class);
    }

}
