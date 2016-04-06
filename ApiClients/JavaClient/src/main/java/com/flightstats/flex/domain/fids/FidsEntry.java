package com.flightstats.flex.domain.fids;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class FidsEntry {
    public static final String ALL_FIELDS =
            "flightId," +
                    "lastUpdatedTime," +
                    "lastUpdatedTimeUtc," +
                    "lastUpdatedDate," +
                    "lastUpdatedDateUtc," +
                    "dayOffset," +
                    "statusCode," +
                    "airlineName," +
                    "airlineCode," +
                    "flightNumber," +
                    "airlineLogoUrlPng," +
                    "airlineLogoUrlSvg," +
                    "isCodeshare," +
                    "operatedFlightNumber," +
                    "operatingAirlineName," +
                    "operatingAirlineCode," +
                    "originAirportName," +
                    "originAirportCode," +
                    "originCity," +
                    "originFamiliarName," +
                    "originStateCode," +
                    "originCountryCode," +
                    "destinationAirportName," +
                    "destinationAirportCode," +
                    "destinationCity," +
                    "destinationFamiliarName," +
                    "destinationStateCode," +
                    "destinationCountryCode," +
                    "flight," +
                    "delayed," +
                    "remarks," +
                    "remarksWithTime," +
                    "remarksCode," +
                    "airportCode," +
                    "airportName," +
                    "city," +
                    "familiarName," +
                    "gate," +
                    "terminal," +
                    "baggage," +
                    "scheduledTime," +
                    "scheduledDate," +
                    "estimatedTime," +
                    "estimatedDate," +
                    "actualTime," +
                    "actualDate," +
                    "currentTime," +
                    "currentDate," +
                    "scheduledGateTime," +
                    "scheduledGateDate," +
                    "estimatedGateTime," +
                    "estimatedGateDate," +
                    "actualGateTime," +
                    "actualGateDate," +
                    "currentGateTime," +
                    "currentGateDate," +
                    "codesharesAsNames," +
                    "codesharesAsCodes," +
                    "uplineAirportNames," +
                    "uplineAirportCodes," +
                    "downlineAirportNames," +
                    "downlineAirportCodes," +
                    "weather," +
                    "weatherGraphic," +
                    "temperatureC," +
                    "temperatureF";

    public final Long flightId;
    public final String lastUpdatedTime;
    public final String lastUpdatedTimeUtc;
    public final String lastUpdatedDate;
    public final String lastUpdatedDateUtc;
    public final Integer dayOffset;
    public final String statusCode;
    public final String airlineName;
    public final String airlineCode;
    public final String flightNumber;
    public final String airlineLogoUrlPng;
    public final String airlineLogoUrlSvg;
    public final String isCodeshare;
    public final String operatedFlightNumber;
    public final String operatingAirlineName;
    public final String operatingAirlineCode;
    public final String originAirportName;
    public final String originAirportCode;
    public final String originCity;
    public final String originFamiliarName;
    public final String originStateCode;
    public final String originCountryCode;
    public final String destinationAirportName;
    public final String destinationAirportCode;
    public final String destinationCity;
    public final String destinationFamiliarName;
    public final String destinationStateCode;
    public final String destinationCountryCode;
    public final String flight;
    public final String delayed;
    public final String remarks;
    public final String remarksWithTime;
    public final String remarksCode;
    public final String airportCode;
    public final String airportName;
    public final String city;
    public final String familiarName;
    public final String gate;
    public final String terminal;
    public final String baggage;
    public final String scheduledTime;
    public final String scheduledDate;
    public final String estimatedTime;
    public final String estimatedDate;
    public final String actualTime;
    public final String actualDate;
    public final String currentTime;
    public final String currentDate;
    public final String scheduledGateTime;
    public final String scheduledGateDate;
    public final String estimatedGateTime;
    public final String estimatedGateDate;
    public final String actualGateTime;
    public final String actualGateDate;
    public final String currentGateTime;
    public final String currentGateDate;
    public final List<String> codesharesAsNames;
    public final List<String> codesharesAsCodes;
    public final List<String> uplineAirportNames;
    public final List<String> uplineAirportCodes;
    public final List<String> downlineAirportNames;
    public final List<String> downlineAirportCodes;
    public final String weather;
    public final String weatherGraphic;
    public final Double temperatureC;
    public final Double temperatureF;
}
