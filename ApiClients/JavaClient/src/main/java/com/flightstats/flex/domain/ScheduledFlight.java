package com.flightstats.flex.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class ScheduledFlight {
    public final String carrierFsCode;
    public final String flightNumber;
    public final String departureAirportFsCode;
    public final String arrivalAirportFsCode;
    public final Integer stops;
    @JsonDeserialize(using = JacksonLocalDateTimeDeserializer.class, as = LocalDateTime.class)
    public final LocalDateTime departureTime;
    @JsonDeserialize(using = JacksonLocalDateTimeDeserializer.class, as = LocalDateTime.class)
    public final LocalDateTime arrivalTime;
    public final String flightEquipmentIataCode;
    public final List<Codeshare> codeshares;
    public final Boolean isCodeshare;
    public final Boolean isWetlease;
    public final String serviceType;
    public final List<String> trafficRestrictions;
    public final Integer elapsedTime;
    public final String brand;
    public final String departureTerminal;
    public final String arrivalTerminal;
    public final List<String> serviceClasses;
    public final Operator operator;
    public final String wetleaseOperatorFsCode;
    public final String referenceCode;
}
