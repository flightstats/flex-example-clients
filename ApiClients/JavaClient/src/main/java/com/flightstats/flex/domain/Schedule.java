package com.flightstats.flex.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Schedule {
    public String flightType;
    public String serviceClasses;
    public String restrictions;
    public List<FlightStatusReference> uplines;
    public List<FlightStatusReference> downlines;
}
