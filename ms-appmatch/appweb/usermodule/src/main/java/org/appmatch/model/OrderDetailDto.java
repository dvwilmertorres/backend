package org.appmatch.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailDto {
    public Long getPkid_user() {
        return pkid_user;
    }

    public void setPkid_user(Long pkid_user) {
        this.pkid_user = pkid_user;
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

    public int getFk_pkid_order() {
        return fk_pkid_order;
    }

    public void setFk_pkid_order(int fk_pkid_order) {
        this.fk_pkid_order = fk_pkid_order;
    }

    public int getFk_pkid_product() {
        return fk_pkid_product;
    }

    public void setFk_pkid_product(int fk_pkid_product) {
        this.fk_pkid_product = fk_pkid_product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(String unit_price) {
        this.unit_price = unit_price;
    }

    public int getFk_pkid_taxes_detail() {
        return fk_pkid_taxes_detail;
    }

    public void setFk_pkid_taxes_detail(int fk_pkid_taxes_detail) {
        this.fk_pkid_taxes_detail = fk_pkid_taxes_detail;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

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
