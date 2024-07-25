package org.appmatch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product", schema = "appmatch_schema")
public class ProductEntity {
    @Id
    private Long pkid_product;
    private String creation_date;
    private String expiration_date;
    private String name;
    private String description;
    private String image;
    private String price;
}
