package com.flightstats.flex.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Equipment {
    public String iata;
    public String name;
    public Boolean turboProp;
    public Boolean jet;
    public Boolean widebody;
    public Boolean regional;
}
