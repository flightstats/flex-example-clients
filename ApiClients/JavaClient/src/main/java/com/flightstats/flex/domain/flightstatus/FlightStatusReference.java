package com.flightstats.flex.domain.flightstatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class FlightStatusReference {
    public String fsCode;
    public Long flightId;
}
