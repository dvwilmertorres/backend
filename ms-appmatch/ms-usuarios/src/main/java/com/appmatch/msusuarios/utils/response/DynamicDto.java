package com.appmatch.msusuarios.utils.response;

import java.util.HashMap;
import java.util.Map;

public class DynamicDto {
    private final Map<String, Object> properties = new HashMap<>();

    public void addProperty(String key, Object value) {
        properties.put(key, value);
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return "DynamicDto{" +
                "properties=" + properties +
                '}';
    }
}
