package com.flightstats.flex.domain.flightstatus;

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
public class FlightStatusResponse {
    // Some responses return a single value and some an array, need to support mappings for both.
    public FlightStatus flightStatus;
    public List<FlightStatus> flightStatuses;

    public Appendix appendix;
}
