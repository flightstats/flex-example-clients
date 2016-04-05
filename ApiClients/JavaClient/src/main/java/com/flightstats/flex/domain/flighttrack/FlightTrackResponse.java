package com.flightstats.flex.domain.flighttrack;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.flightstats.flex.domain.Appendix;
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
public class FlightTrackResponse {
    public FlightTrack flightTrack;
    public List<FlightTrack> flightTracks;
    public List<FlightTrack> flightPositions;
    public Appendix appendix;
}
