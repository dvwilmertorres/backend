package com.appmatch.msusuarios.model;

import lombok.*;


public class CategoryDto {
    public Long getPkid_category() {
        return pkid_category;
    }

    public void setPkid_category(Long pkid_category) {
        this.pkid_category = pkid_category;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getFk_pkid_category_parent() {
        return fk_pkid_category_parent;
    }

    public void setFk_pkid_category_parent(Long fk_pkid_category_parent) {
        this.fk_pkid_category_parent = fk_pkid_category_parent;
    }

    private Long pkid_category;
    private String creation_date;
    private String expiration_date;
    private String name;
    private String description;
    private Long fk_pkid_category_parent;
}
