package com.flightstats.flex.domain.flightstatus;

import com.flightstats.flex.domain.AirportResources;
import com.flightstats.flex.domain.Codeshare;
import com.flightstats.flex.domain.ConfirmedIncident;
import com.flightstats.flex.domain.DateUtcAndLocal;
import com.flightstats.flex.domain.Delays;
import com.flightstats.flex.domain.OperationalTimes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class FlightStatus {
    public Long flightId;
    public String carrierFsCode;
    public String operatingCarrierFsCode;
    public String primaryCarrierFsCode;
    public String flightNumber;
    public String departureAirportFsCode;
    public String arrivalAirportFsCode;
    public String divertedAirportFsCode;
    public DateUtcAndLocal departureDate;
    public DateUtcAndLocal arrivalDate;
    public String status;
    public Schedule schedule;
    public OperationalTimes operationalTimes;
    public List<Codeshare> codeshares;
    public Delays delays;
    public FlightDurations flightDurations;
    public AirportResources airportResources;
    public FlightEquipment flightEquipment;
    public List<FlightStatusUpdate> flightStatusUpdates;
    public List<IrregularOperation> irregularOperations;
    public ConfirmedIncident confirmedIncident;
}
