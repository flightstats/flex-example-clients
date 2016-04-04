package com.flightstats.flex.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Airport {
    public String fs;
    public String iata;
    public String icao;
    public String faa;
    public String name;
    public String street1;
    public String street2;
    public String city;
    public String cityCode;
    public String stateCode;
    public String postalCode;
    public String countryCode;
    public String district;
    public String countryName;
    public String regionName;
    public String timeZoneRegionName;
    public String weatherZone;
    public String localTime;
    public double utcOffsetHours;
    public double latitude;
    public double longitude;
    public Integer elevationFeet;
    public int classification;
    public boolean active;
    public String dateFrom;
    public String dateTo;
    public String weatherUrl;
    public String delayIndexUrl;
}
