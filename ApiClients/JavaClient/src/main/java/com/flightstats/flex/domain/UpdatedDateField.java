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
public class UpdatedDateField {
    public String field;
    @JsonDeserialize(using = JacksonLocalDateTimeDeserializer.class, as = LocalDateTime.class)
    public LocalDateTime originalDateLocal;
    @JsonDeserialize(using = JacksonLocalDateTimeDeserializer.class, as = LocalDateTime.class)
    public LocalDateTime newDateLocal;
    @JsonDeserialize(using = JacksonZonedDateTimeDeserializer.class, as = ZonedDateTime.class)
    public ZonedDateTime originalDateUtc;
    @JsonDeserialize(using = JacksonZonedDateTimeDeserializer.class, as = ZonedDateTime.class)
    public ZonedDateTime newDateUtc;
}
