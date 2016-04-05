package com.flightstats.flex.client;

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
public class HistoricalFlightStatusClient {
    private String appKey;
    private String appId;

    // By Flight
    public FlightStatusResponse byFlightId(String id, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/flightstatus/historical/rest/v2/json/flight/status/%s", id),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), FlightStatusResponse.class);
    }

    public FlightStatusResponse byDepartingFlight(String carrier, String flight, LocalDate date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/flightstatus/historical/rest/v2/json/flight/status/%s/%s/dep/%s/%s/%s",
                        carrier, flight, date.getYear(), date.getMonthValue(), date.getDayOfMonth()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), FlightStatusResponse.class);
    }

    public FlightStatusResponse byArrivingFlight(String carrier, String flight, LocalDate date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/flightstatus/historical/rest/v2/json/flight/status/%s/%s/arr/%s/%s/%s",
                        carrier, flight, date.getYear(), date.getMonthValue(), date.getDayOfMonth()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), FlightStatusResponse.class);
    }

    // By Airport
    public FlightStatusResponse byDepartureAirport(String airport, LocalDateTime date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/flightstatus/historical/rest/v2/json/airport/status/%s/dep/%s/%s/%s/%s",
                        airport, date.getYear(), date.getMonthValue(), date.getDayOfMonth(), date.getHour()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), FlightStatusResponse.class);
    }

    public FlightStatusResponse byArrivalAirport(String airport, LocalDateTime date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/flightstatus/historical/rest/v2/json/airport/status/%s/arr/%s/%s/%s/%s",
                        airport, date.getYear(), date.getMonthValue(), date.getDayOfMonth(), date.getHour()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), FlightStatusResponse.class);
    }

    // By Route
    public FlightStatusResponse byRouteDeparture(String departureAirport, String arrivalAirport, LocalDate date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/flightstatus/historical/rest/v2/json/route/status/%s/%s/dep/%s/%s/%s",
                        departureAirport, arrivalAirport, date.getYear(), date.getMonthValue(), date.getDayOfMonth()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), FlightStatusResponse.class);
    }

    public FlightStatusResponse byRouteArrival(String departureAirport, String arrivalAirport, LocalDate date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/flightstatus/historical/rest/v2/json/route/status/%s/%s/arr/%s/%s/%s",
                        departureAirport, arrivalAirport, date.getYear(), date.getMonthValue(), date.getDayOfMonth()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), FlightStatusResponse.class);
    }
}
