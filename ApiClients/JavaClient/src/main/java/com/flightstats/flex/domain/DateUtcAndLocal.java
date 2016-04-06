package com.flightstats.flex.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Value
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class DateUtcAndLocal {
    @JsonDeserialize(using = JacksonZonedDateTimeDeserializer.class, as = ZonedDateTime.class)
    public ZonedDateTime dateUtc;
    @JsonDeserialize(using = JacksonLocalDateTimeDeserializer.class, as = LocalDateTime.class)
    public LocalDateTime dateLocal;
}
