package com.flightstats.flex.client;

import com.flightstats.flex.domain.flighttrack.FlightTrackResponse;
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

    public FlightTrackResponse byFlightId(String id, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri("/flightstatus/rest/v2/json/flight/track/" + id, options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), FlightTrackResponse.class);
    }

    public FlightTrackResponse byDepartingFlight(String carrier, String flight, LocalDate date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/flightstatus/rest/v2/json/flight/tracks/%s/%s/dep/%s/%s/%s",
                        carrier, flight, date.getYear(), date.getMonthValue(), date.getDayOfMonth()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), FlightTrackResponse.class);
    }

    public FlightTrackResponse byArrivingFlight(String carrier, String flight, LocalDate date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/flightstatus/rest/v2/json/flight/tracks/%s/%s/arr/%s/%s/%s",
                        carrier, flight, date.getYear(), date.getMonthValue(), date.getDayOfMonth()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), FlightTrackResponse.class);
    }
}
