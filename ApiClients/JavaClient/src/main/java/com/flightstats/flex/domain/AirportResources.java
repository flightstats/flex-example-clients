package com.flightstats.flex.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class AirportResources {
    public String departureTerminal;
    public String departureGate;
    public String arrivalTerminal;
    public String arrivalGate;
    public String baggage;
}
