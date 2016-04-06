package com.flightstats.flex.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.flightstats.flex.domain.JacksonZonedDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.ZonedDateTime;

@Builder
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Position {
    public Double lon;
    public Double lat;
    public Long speedMph;
    public Long altitudeFt;
    public String source;
    @JsonDeserialize(using = JacksonZonedDateTimeDeserializer.class, as = ZonedDateTime.class)
    ZonedDateTime date;
    public Long course;
    public Long vrateMps;
    public String phase;
    @JsonDeserialize(using = JacksonZonedDateTimeDeserializer.class, as = ZonedDateTime.class)
    public ZonedDateTime lastObserved;
}
