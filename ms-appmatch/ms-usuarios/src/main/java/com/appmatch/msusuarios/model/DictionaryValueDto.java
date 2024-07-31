package com.appmatch.msusuarios.model;

import java.util.UUID;

public class DictionaryValueDto {

    private String value;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DictionaryValueDto(String value, String description, String id) {
        this.value = value;
        this.description = description;
        this.id = id;
    }
}
