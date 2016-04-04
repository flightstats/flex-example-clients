package com.flightstats.flex.domain.flighttrack;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.flightstats.flex.domain.JacksonZonedDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.ZonedDateTime;

@Value
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class IrregularOperation {
    public String type;
    @JsonDeserialize(using = JacksonZonedDateTimeDeserializer.class, as = ZonedDateTime.class)
    public ZonedDateTime dateUtc;
    public String message;
    public Long relatedFlightId;
    public String newArrivalAirportFsCode;

}
