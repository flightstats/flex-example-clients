package com.flightstats.flex.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class UpdatedTextField {
    public String field;
    public String originalText;
    public String newText;
}
