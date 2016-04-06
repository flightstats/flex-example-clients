package com.flightstats.flex.domain.delayindex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.flightstats.flex.domain.DelayIndex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DelayIndexResponse {
    List<DelayIndex> delayIndexes;
}
