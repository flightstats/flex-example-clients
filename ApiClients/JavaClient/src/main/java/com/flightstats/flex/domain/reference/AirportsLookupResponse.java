package com.flightstats.flex.domain.reference;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.flightstats.flex.domain.Airline;
import com.flightstats.flex.domain.Airport;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AirportsLookupResponse {
    // Some responses return a single value and some an array, need to support mappings for both.
    public Airport airport;
    public List<Airport> airports;
}
