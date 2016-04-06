package com.flightstats.flex.client;

import com.flightstats.flex.domain.fids.FidsResponse;
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
public class FidsClient {
    public static final String REQUESTED_FIELDS = "requestedFields";
    public static final String CODE_TYPE = "codeType";
    public static final String SORT_FIELDS = "sortFields";
    public static final String EXCLUDE_AIRLINES = "excludeAirlines";
    public static final String INCLUDE_AIRLINES = "includeAirlines";
    public static final String INCLUDE_CODESHARES = "includeCodeshares";
    public static final String TERMINAL = "terminal";
    public static final String TIME_FORMAT = "timeFormat";
    public static final String TIME_WINDOW_BEGIN = "timeWindowBegin";
    public static final String TIME_WINDOW_END = "timeWindowEnd";
    public static final String MAX_FLIGHTS = "maxFlights";
    public static final String LATE_MINUTES = "lateMinutes";
    public static final String BOARDING_MINUTES = "boardingMinutes";
    public static final String USE_RUNWAY_TIMES = "useRunwayTimes";
    public static final String EXCLUDE_CARGO_ONLY_FLIGHTS = "excludeCargoOnlyFlights";


    private String appKey;
    private String appId;

    public FidsResponse byDepartingAirport(String airport, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/fids/rest/v1/json/%s/departures", airport),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), FidsResponse.class);
    }

    public FidsResponse byArrivalAirport(String airport, Map<String, String> options) {
        UriBuilder builder = FlexHelper.createRequestUri(
                String.format("/fids/rest/v1/json/%s/arrivals", airport),
                options, appId, appKey);
        return FlexHelper.executeHttpGet(builder.build(), FidsResponse.class);
    }
}
