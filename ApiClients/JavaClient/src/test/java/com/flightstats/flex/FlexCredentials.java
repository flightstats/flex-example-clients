package com.flightstats.flex;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FlexCredentials {
    private static final Properties props = loadProperties();
    public static final String appId = props.getProperty("appId");
    public static final String appKey = props.getProperty("appKey");

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (final InputStream stream = FlexCredentials.class.getResourceAsStream("flex.properties")) {
            properties.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}
