package com.flightstats.flex.flightstatusfeed.client.util;

import java.net.URI;
import java.util.Optional;

public interface FeedState {
    Optional<URI> retrieveLastURI();
    void updateLastURI(URI uri);
}
