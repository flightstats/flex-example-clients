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
public class FlightSchedule {
    public final String carrierFsCode;
    public final String flightNumber;
    public final String brand;
    public final String departureAirportFsCode;
    public final String arrivalAirportFsCode;
    public final int stops;
    public final String departureTerminal;
    public final String arrivalTerminal;
    public final String flightEquipmentIataCode;
    @JsonDeserialize(using = JacksonLocalDateTimeDeserializer.class, as = LocalDateTime.class)
    public final LocalDateTime departureTime;
    @JsonDeserialize(using = JacksonLocalDateTimeDeserializer.class, as = LocalDateTime.class)
    public final LocalDateTime arrivalTime;
    public final boolean isCodeshare;
    public final boolean isWetlease;
    public final String serviceType;
    public final Operator operator;
    public final List<String> serviceClasses;
    public final List<String> trafficRestrictions;
    public final List<Codeshare> codeshares;
    public final String wetleaseOperatorFsCode;
    public final String referenceCode;
}
