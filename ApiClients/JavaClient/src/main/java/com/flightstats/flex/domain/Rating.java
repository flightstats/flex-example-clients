package com.flightstats.flex.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Rating {

    public final String departureAirportFsCode;
    public final String arrivalAirportFsCode;
    public final String airlineFsCode;
    public final String flightNumber;
    public final Integer codeshares;
    public final Integer directs;
    public final Integer observations;
    public final Integer ontime;
    public final Integer late15;
    public final Integer late30;
    public final Integer late45;
    public final Integer cancelled;
    public final Integer diverted;
    public final Double ontimePercent;
    public final Integer delayObservations;
    public final Integer delayMean;
    public final Double delayStandardDeviation;
    public final Integer delayMin;
    public final Integer delayMax;
    public final Double allOntimeCumulative;
    public final Double allOntimeStars;
    public final Double allDelayCumulative;
    public final Double allDelayStars;
    public final Double allStars;
}