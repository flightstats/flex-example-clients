package com.flightstats.flex.client;

import com.flightstats.flex.domain.reference.AirlinesLookupResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import javax.ws.rs.core.UriBuilder;
import java.time.LocalDate;
import java.util.Map;

@Value
@Builder
@AllArgsConstructor
public class ReferenceLookupClient {
    private String appKey;
    private String appId;

    // Airlines
    public AirlinesLookupResponse airlinesAll(Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri("/airlines/rest/v1/json/all", options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), AirlinesLookupResponse.class);
    }

    public AirlinesLookupResponse airlinesActive(Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri("/airlines/rest/v1/json/active", options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), AirlinesLookupResponse.class);
    }

    public AirlinesLookupResponse airlinesActiveForDate(LocalDate date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/airlines/rest/v1/json/active/%d/%d/%d", date.getYear(), date.getMonthValue(), date.getDayOfMonth()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), AirlinesLookupResponse.class);
    }

    public AirlinesLookupResponse airlinesByFsCode(String code, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/airlines/rest/v1/json/fs/%s", code),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), AirlinesLookupResponse.class);
    }

    public AirlinesLookupResponse airlinesByIataCode(String code, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/airlines/rest/v1/json/iata/%s", code),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), AirlinesLookupResponse.class);
    }

    public AirlinesLookupResponse airlinesByIataCodeOnDate(String code, LocalDate date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/airlines/rest/v1/json/iata/%s/%d/%d/%d", code, date.getYear(), date.getMonthValue(), date.getDayOfMonth()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), AirlinesLookupResponse.class);
    }

    public AirlinesLookupResponse airlinesByIcaoCode(String code, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/airlines/rest/v1/json/icao/%s", code),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), AirlinesLookupResponse.class);
    }

    public AirlinesLookupResponse airlinesByIcaoCodeOnDate(String code, LocalDate date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/airlines/rest/v1/json/icao/%s/%d/%d/%d", code, date.getYear(), date.getMonthValue(), date.getDayOfMonth()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), AirlinesLookupResponse.class);
    }

}
