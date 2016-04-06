package com.flightstats.flex.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.ZonedDateTime;

@Value
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class DelayIndex {
    public final Airport airport;
    public final Integer rawScore;
    public final Integer normalizedScore;
    @JsonDeserialize(using = JacksonZonedDateTimeDeserializer.class, as = ZonedDateTime.class)
    public final ZonedDateTime dateStart;
    @JsonDeserialize(using = JacksonZonedDateTimeDeserializer.class, as = ZonedDateTime.class)
    public final ZonedDateTime dateEnd;
    public final Integer flights;
    public final Integer observations;
    public final Integer canceled;
    public final Integer onTime;
    public final Integer delayed15;
    public final Integer delayed30;
    public final Integer delayed45;
    public final Integer delta;
}
