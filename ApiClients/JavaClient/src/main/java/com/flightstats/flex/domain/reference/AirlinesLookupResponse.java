package com.flightstats.flex.domain.reference;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.flightstats.flex.domain.Airline;
import com.flightstats.flex.domain.Appendix;
import com.flightstats.flex.domain.flighttrack.FlightTrack;
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
public class AirlinesLookupResponse {
    // Some responses return a single value and some an array, need to support mappings for both.
    public Airline airline;
    public List<Airline> airlines;
}
