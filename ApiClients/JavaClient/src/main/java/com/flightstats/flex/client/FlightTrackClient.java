package com.flightstats.flex.client;

import com.flightstats.flex.domain.flighttrack.FlightTrackResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import javax.ws.rs.core.UriBuilder;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Map;

@Value
@Builder
@AllArgsConstructor
public class FlightTrackClient {
    public static final String AIRPORT = "airport";
    public static final String CODE_TYPE = "codeType";
    public static final String UTC = "utc";
    public static final String MAX_POSITIONS = "maxPositions";
    public static final String MAX_POSITION_AGE_MINUTES = "maxPositionAgeMinutes";
    public static final String HOUR_OF_DAY = "hourOfDay";
    public static final String NUM_HOURS = "numHours";
    public static final String INCLUDE_FLIGHT_PLAN = "includeFlightPlan";

    private String appKey;
    private String appId;

    // By Flight
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

    // By Airport
    public FlightTrackResponse byDepartureAirport(String airport, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/flightstatus/rest/v2/json/airport/tracks/%s/dep", airport),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), FlightTrackResponse.class);
    }

    public FlightTrackResponse byArrivalAirport(String airport, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/flightstatus/rest/v2/json/airport/tracks/%s/arr", airport),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), FlightTrackResponse.class);
    }

    // Flights Near
    public FlightTrackResponse byBoundingBox(double topLat, double leftLon, double bottomLat, double rightLon, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/flightstatus/rest/v2/json/flightsNear/%f/%f/%f/%f", topLat, leftLon, bottomLat, rightLon),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), FlightTrackResponse.class);
    }

    public FlightTrackResponse byRadius(double lat, double lon, int miles, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/flightstatus/rest/v2/json/flightsNear/%f/%f/%d", lat, lon, miles),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), FlightTrackResponse.class);
    }
}
