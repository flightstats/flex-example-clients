package com.flightstats.flex.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Delays {
    public Integer departureGateDelayMinutes;
    public Integer departureRunwayDelayMinutes;
    public Integer arrivalGateDelayMinutes;
    public Integer arrivalRunwayDelayMinutes;
}
