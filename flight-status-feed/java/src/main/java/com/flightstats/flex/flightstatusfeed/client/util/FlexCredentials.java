package com.flightstats.flex.flightstatusfeed.client.util;

import lombok.Value;

@Value
public class FlexCredentials {

    private final String appId;
    private final String appKey;

    public FlexCredentials(String appId, String appKey) {
        this.appId = appId;
        this.appKey = appKey;
    }
}
