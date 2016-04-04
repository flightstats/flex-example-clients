package com.flightstats.flex.domain.flightstatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class FlightDurations {
    public Integer scheduledBlockMinutes;
    public Integer blockMinutes;
    public Integer scheduledAirMinutes;
    public Integer airMinutes;
    public Integer scheduledTaxiOutMinutes;
    public Integer taxiOutMinutes;
    public Integer scheduledTaxiInMinutes;
    public Integer taxiInMinutes;
}
