package com.flightstats.flex.domain.connections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.flightstats.flex.domain.Appendix;
import com.flightstats.flex.domain.ConnectionFlight;
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
public class ConnectionsResponse {
    List<ConnectionFlight> connections;
    public Appendix appendix;
}
