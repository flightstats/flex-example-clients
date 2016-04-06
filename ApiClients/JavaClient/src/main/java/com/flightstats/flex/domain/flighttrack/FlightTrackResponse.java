package com.flightstats.flex.domain.flighttrack;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.flightstats.flex.domain.Appendix;
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
public class FlightTrackResponse {
    // Some responses return a single value and some an array, need to support mappings for both.
    public FlightTrack flightTrack;
    public List<FlightTrack> flightTracks;

    // For FlightsNear responses
    public List<FlightTrack> flightPositions;
    public Appendix appendix;
}
