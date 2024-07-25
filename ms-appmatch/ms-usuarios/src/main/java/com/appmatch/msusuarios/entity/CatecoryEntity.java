package com.appmatch.msusuarios.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "category", schema = "appmatch_schema")
@Data
public class CatecoryEntity {
    @Id
    private Long pkid_category;
    private String creation_date;
    private String expiration_date;
    private String name;
    private String description;
    private Long fk_pkid_category_parent;
}
