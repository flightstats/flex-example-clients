package com.flightstats.flex.domain.schedules;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.flightstats.flex.domain.Airline;
import com.flightstats.flex.domain.Appendix;
import com.flightstats.flex.domain.FlightSchedule;
import com.flightstats.flex.domain.Schedule;
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
public class SchedulesResponse {
    List<FlightSchedule> scheduledFlights;
    public Appendix appendix;
}
