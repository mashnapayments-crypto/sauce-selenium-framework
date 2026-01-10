package com.example.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties props = new Properties();

    static {
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties")) {
            if (is != null) {
                props.load(is);
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to load config.properties", e);
        }
    }

    public static String get(String key) {
        String system = System.getProperty(key);
        if (system != null) return system;
        return props.getProperty(key);
    }

    public static boolean getBoolean(String key) {
        String v = get(key);
        return v != null && (v.equalsIgnoreCase("true") || v.equals("1"));
    }

    public static int getInt(String key, int defaultVal) {
        String v = get(key);
        if (v == null) return defaultVal;
        try {
            return Integer.parseInt(v);
        } catch (NumberFormatException e) {
            return defaultVal;
        }
    }
}
