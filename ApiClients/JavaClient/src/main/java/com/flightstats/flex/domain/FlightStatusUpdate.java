package com.flightstats.flex.domain;

import com.flightstats.flex.domain.DateUtcAndLocal;
import com.flightstats.flex.domain.UpdatedDateField;
import com.flightstats.flex.domain.UpdatedTextField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class FlightStatusUpdate {
    public DateUtcAndLocal updatedAt;
    public String source;
    public List<UpdatedTextField> updatedTextFields;
    public List<UpdatedDateField> updatedDateFields;
}