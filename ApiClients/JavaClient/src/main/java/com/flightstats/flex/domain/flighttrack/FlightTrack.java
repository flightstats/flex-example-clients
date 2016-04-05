package com.flightstats.flex.domain.flighttrack;

import com.flightstats.flex.domain.DateUtcAndLocal;
import com.flightstats.flex.domain.IrregularOperation;
import com.flightstats.flex.domain.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class FlightTrack {
    public Long flightId;
    public String carrierFsCode;
    public String operatingCarrierFsCode;
    public String primaryCarrierFsCode;
    public String flightNumber;
    public String tailNumber;
    public String callsign;
    public String departureAirportFsCode;
    public String arrivalAirportFsCode;
    public String divertedAirportFsCode;
    public DateUtcAndLocal departureDate;
    public String equipment;
    public Long delayMinutes;
    public Double bearing;
    public Double heading;
    public String source;
    public List<Position> positions;
    public List<Position> waypoints;
    public List<IrregularOperation> irregularOperations;
}
