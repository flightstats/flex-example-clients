package com.flightstats.flex.domain.flightstatus;

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
public class FlightStatusByFlightResponse {
    public FlightStatus flightStatus;
    public List<FlightStatus> flightStatuses;
    public Appendix appendix;
}
