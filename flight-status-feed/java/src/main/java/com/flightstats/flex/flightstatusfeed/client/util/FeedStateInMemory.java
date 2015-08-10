package com.flightstats.flex.flightstatusfeed.client.util;

import java.net.URI;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class FeedStateInMemory implements FeedState {

    private AtomicReference<URI> uri = new AtomicReference<>(null);

    @Override
    public Optional<URI> retrieveLastURI() {
        return Optional.ofNullable(uri.get());
    }

    @Override
    public void updateLastURI(URI uri) {
        this.uri.set(uri);
    }
}
