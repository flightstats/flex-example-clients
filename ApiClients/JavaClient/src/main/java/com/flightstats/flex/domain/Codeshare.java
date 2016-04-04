package com.flightstats.flex.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.xml.bind.annotation.XmlType;

@Value
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@XmlType(propOrder = {})
public class Codeshare {
    public String fsCode;
    public String flightNumber;
    public String relationship;
}
