package com.flightstats.flex.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class RequestParameter<T> {
    public String requested;
    public T interpreted;
}
