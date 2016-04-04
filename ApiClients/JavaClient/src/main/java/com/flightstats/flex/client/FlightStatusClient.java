package com.flightstats.flex.client;

import com.flightstats.flex.domain.flightstatus.FlightStatusByFlightResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import javax.ws.rs.core.UriBuilder;
import java.time.LocalDate;
import java.util.Map;

@Value
@Builder
@AllArgsConstructor
public class FlightStatusClient {
    private String appKey;
    private String appId;

    public FlightStatusByFlightResponse byFlightId(String id, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri("/flightstatus/rest/v2/json/flight/status/" + id, options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), FlightStatusByFlightResponse.class);
    }

    public FlightStatusByFlightResponse byDepartingFlight(String carrier, String flight, LocalDate date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/flightstatus/rest/v2/json/flight/status/%s/%s/dep/%s/%s/%s",
                        carrier, flight, date.getYear(), date.getMonthValue(), date.getDayOfMonth()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), FlightStatusByFlightResponse.class);
    }

    public FlightStatusByFlightResponse byArrivingFlight(String carrier, String flight, LocalDate date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/flightstatus/rest/v2/json/flight/status/%s/%s/arr/%s/%s/%s",
                        carrier, flight, date.getYear(), date.getMonthValue(), date.getDayOfMonth()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), FlightStatusByFlightResponse.class);
    }
}
