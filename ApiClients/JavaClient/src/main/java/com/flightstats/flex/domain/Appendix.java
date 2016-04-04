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
public class Appendix {
    public List<Airline> airlines;
    public List<Airport> airports;
    public List<Equipment> equipments;
}
