package com.flightstats.flex.domain.flightstatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class FlightEquipment {
    public String scheduledEquipmentIataCode;
    public String actualEquipmentIataCode;
    public String tailNumber;
}
