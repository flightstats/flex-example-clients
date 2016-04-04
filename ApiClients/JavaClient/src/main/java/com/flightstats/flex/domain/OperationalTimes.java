package com.flightstats.flex.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class OperationalTimes {
    public DateUtcAndLocal publishedDeparture;
    public DateUtcAndLocal scheduledGateDeparture;
    public DateUtcAndLocal estimatedGateDeparture;
    public DateUtcAndLocal actualGateDeparture;
    public DateUtcAndLocal flightPlanPlannedDeparture;
    public DateUtcAndLocal scheduledRunwayDeparture;
    public DateUtcAndLocal estimatedRunwayDeparture;
    public DateUtcAndLocal actualRunwayDeparture;

    public DateUtcAndLocal publishedArrival;
    public DateUtcAndLocal flightPlanPlannedArrival;
    public DateUtcAndLocal scheduledGateArrival;
    public DateUtcAndLocal estimatedGateArrival;
    public DateUtcAndLocal actualGateArrival;
    public DateUtcAndLocal scheduledRunwayArrival;
    public DateUtcAndLocal estimatedRunwayArrival;
    public DateUtcAndLocal actualRunwayArrival;
}
