package com.flightstats.flex.client;

import com.flightstats.flex.domain.flighttrack.FlightTrackByFlightResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import javax.ws.rs.core.UriBuilder;
import java.time.LocalDate;
import java.util.Map;

@Value
@Builder
@AllArgsConstructor
public class FlightTrackClient {
    private String appKey;
    private String appId;

    public FlightTrackByFlightResponse byFlightId(String id, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri("/flightstatus/rest/v2/json/flight/track/" + id, options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), FlightTrackByFlightResponse.class);
    }

    public FlightTrackByFlightResponse byDepartingFlight(String carrier, String flight, LocalDate date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/flightstatus/rest/v2/json/flight/tracks/%s/%s/dep/%s/%s/%s",
                        carrier, flight, date.getYear(), date.getMonthValue(), date.getDayOfMonth()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), FlightTrackByFlightResponse.class);
    }

    public FlightTrackByFlightResponse byArrivingFlight(String carrier, String flight, LocalDate date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/flightstatus/rest/v2/json/flight/tracks/%s/%s/arr/%s/%s/%s",
                        carrier, flight, date.getYear(), date.getMonthValue(), date.getDayOfMonth()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), FlightTrackByFlightResponse.class);
    }
}
