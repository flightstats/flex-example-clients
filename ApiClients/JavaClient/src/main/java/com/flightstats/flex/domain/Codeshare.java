package com.flightstats.flex.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.xml.bind.annotation.XmlType;
import java.util.List;

@Value
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@XmlType(propOrder = {})
public class Codeshare {
    public String carrierFsCode;
    public String flightNumber;
    public String serviceType;
    public String fsCode;
    public String relationship;
    public List<String> serviceClasses;
    public List<String> trafficRestrictions;
    public String referenceCode;
}
