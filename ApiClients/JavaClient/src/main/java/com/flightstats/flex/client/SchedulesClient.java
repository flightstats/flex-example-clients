package com.flightstats.flex.client;

import com.flightstats.flex.domain.schedules.SchedulesResponse;
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
public class SchedulesClient {
    public static String CODE_TYPE = "codeType";

    private String appKey;
    private String appId;

    public SchedulesResponse byCarrierAndFlightDepartingOnDate(String carrier, String flight, LocalDate date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/schedules/rest/v1/json/flight/%s/%s/departing/%s/%s/%s",
                        carrier, flight, date.getYear(), date.getMonthValue(), date.getDayOfMonth()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), SchedulesResponse.class);
    }

    public SchedulesResponse byCarrierAndFlightArrivingOnDate(String carrier, String flight, LocalDate date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/schedules/rest/v1/json/flight/%s/%s/arriving/%s/%s/%s",
                        carrier, flight, date.getYear(), date.getMonthValue(), date.getDayOfMonth()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), SchedulesResponse.class);
    }

    public SchedulesResponse byRouteDepartingOnDate(String departing, String arriving, LocalDate date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/schedules/rest/v1/json/from/%s/to/%s/departing/%s/%s/%s",
                        departing, arriving, date.getYear(), date.getMonthValue(), date.getDayOfMonth()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), SchedulesResponse.class);
    }

    public SchedulesResponse byRouteArrivingOnDate(String departing, String arriving, LocalDate date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/schedules/rest/v1/json/from/%s/to/%s/arriving/%s/%s/%s",
                        departing, arriving, date.getYear(), date.getMonthValue(), date.getDayOfMonth()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), SchedulesResponse.class);
    }

    public SchedulesResponse byAirportDepartingOnDate(String airport, LocalDateTime date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/schedules/rest/v1/json/from/%s/departing/%s/%s/%s/%s",
                        airport, date.getYear(), date.getMonthValue(), date.getDayOfMonth(), date.getHour()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), SchedulesResponse.class);
    }

    public SchedulesResponse byAirportArrivingOnDate(String airport, LocalDateTime date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/schedules/rest/v1/json/to/%s/arriving/%s/%s/%s/%s",
                        airport, date.getYear(), date.getMonthValue(), date.getDayOfMonth(), date.getHour()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), SchedulesResponse.class);
    }
}
