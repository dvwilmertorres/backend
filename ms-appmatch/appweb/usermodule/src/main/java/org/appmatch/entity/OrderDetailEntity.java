package org.appmatch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "order_detail", schema = "appmatch_schema")
public class OrderDetailEntity {
    @Id
    private Long pkid_user;
    private String creation_date;
    private String expiration_date;
    private int fk_pkid_order;
    private int fk_pkid_product;
    private int amount;
    private String unit_price;
    private int fk_pkid_taxes_detail;
    private String total_price;

}
