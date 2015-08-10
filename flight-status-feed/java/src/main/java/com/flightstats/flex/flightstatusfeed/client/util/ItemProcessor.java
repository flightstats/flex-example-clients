package com.flightstats.flex.flightstatusfeed.client.util;

import com.google.gson.JsonObject;

public interface ItemProcessor {
    void process(JsonObject jsonObject);
}
