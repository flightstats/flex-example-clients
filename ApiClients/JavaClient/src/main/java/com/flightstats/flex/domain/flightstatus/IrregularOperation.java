package com.flightstats.flex.domain.flightstatus;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.flightstats.flex.domain.JacksonZonedDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
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
