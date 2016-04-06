package com.flightstats.flex.client;

import com.flightstats.flex.domain.reference.AirlinesLookupResponse;
import com.flightstats.flex.domain.reference.AirportsLookupResponse;
import com.flightstats.flex.domain.reference.EquipmentLookupResponse;
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

    // Airports
    public AirportsLookupResponse airportsActive(Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri("/airports/rest/v1/json/active", options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), AirportsLookupResponse.class);
    }

    public AirportsLookupResponse airportsActiveForDate(LocalDate date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/airports/rest/v1/json/active/%d/%d/%d", date.getYear(), date.getMonthValue(), date.getDayOfMonth()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), AirportsLookupResponse.class);
    }

    public AirportsLookupResponse airportsAll(Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri("/airports/rest/v1/json/all", options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), AirportsLookupResponse.class);
    }

    public AirportsLookupResponse airportsByCodeToday(String code, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/airports/rest/v1/json/%s/today", code),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), AirportsLookupResponse.class);
    }

    public AirportsLookupResponse airportsByCodeOnDate(String code, LocalDate date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/airports/rest/v1/json/%s/%d/%d/%d", code, date.getYear(), date.getMonthValue(), date.getDayOfMonth()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), AirportsLookupResponse.class);
    }

    public AirportsLookupResponse airportsByCityCode(String code, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/airports/rest/v1/json/cityCode/%s", code),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), AirportsLookupResponse.class);
    }

    public AirportsLookupResponse airportsByCountryCode(String code, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/airports/rest/v1/json/countryCode/%s", code),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), AirportsLookupResponse.class);
    }

    public AirportsLookupResponse airportsByFsCode(String code, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/airports/rest/v1/json/fs/%s", code),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), AirportsLookupResponse.class);
    }

    public AirportsLookupResponse airportsByIataCode(String code, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/airports/rest/v1/json/iata/%s", code),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), AirportsLookupResponse.class);
    }

    public AirportsLookupResponse airportsByIataCodeOnDate(String code, LocalDate date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/airports/rest/v1/json/iata/%s/%d/%d/%d", code, date.getYear(), date.getMonthValue(), date.getDayOfMonth()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), AirportsLookupResponse.class);
    }

    public AirportsLookupResponse airportsByIcaoCode(String code, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/airports/rest/v1/json/icao/%s", code),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), AirportsLookupResponse.class);
    }

    public AirportsLookupResponse airportsByIcaoCodeOnDate(String code, LocalDate date, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/airports/rest/v1/json/icao/%s/%d/%d/%d", code, date.getYear(), date.getMonthValue(), date.getDayOfMonth()),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), AirportsLookupResponse.class);
    }

    public AirportsLookupResponse airportsWithinRadius(double lat, double lon, int miles, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/airports/rest/v1/json/withinRadius/%f/%f/%d", lat, lon, miles),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), AirportsLookupResponse.class);
    }

    // Equipment
    public EquipmentLookupResponse equipmentAll(Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri("/equipment/rest/v1/json/all", options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), EquipmentLookupResponse.class);
    }

    public EquipmentLookupResponse equipmentByIataCode(String code, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/equipment/rest/v1/json/iata/%s", code),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), EquipmentLookupResponse.class);
    }

}
