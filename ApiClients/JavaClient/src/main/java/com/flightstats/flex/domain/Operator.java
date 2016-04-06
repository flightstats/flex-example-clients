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
public class Operator {
    public final String carrierFsCode;
    public final String flightNumber;
    public final String serviceType;
    public final List<String> serviceClasses;
    public final List<String> trafficRestrictions;
}
