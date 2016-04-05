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

/**
 * The superset of all possible response fields for all FlightStatus by Flight queries.
 */
@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AirlinesLookupResponse {
    public Airline airline;
    public List<Airline> airlines;
}
