package com.flightstats.flex.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Airline {
    public String fs;
    public String iata;
    public String icao;
    public String name;
    public String phoneNumber;
    public boolean active;
    public String dateFrom;
    public String dateTo;
    public String category;
}
