package com.flightstats.flex.domain;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class JacksonZonedDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {
    private static final DateTimeFormatter ZONED_ISO_DATE_8601 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");

    public ZonedDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return ZonedDateTime.parse(p.getText(), ZONED_ISO_DATE_8601);
    }
}
