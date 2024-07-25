package com.appmatch.msusuarios.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_information", schema = "appmatch_schema")
public class UserInfoEntity {
    public Long getPkid_user_information() {
        return pkid_user_information;
    }

    public void setPkid_user_information(Long pkid_user_information) {
        this.pkid_user_information = pkid_user_information;
    }

    public LocalDateTime  getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDateTime  creation_date) {
        this.creation_date = creation_date;
    }

    public LocalDateTime  getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(LocalDateTime  expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public double getIndicative() {
        return indicative;
    }

    public void setIndicative(double indicative) {
        this.indicative = indicative;
    }

    public double getPhone() {
        return phone;
    }

    public void setPhone(double phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkid_user_information;
    private LocalDateTime creation_date;
    private LocalDateTime  expiration_date;
    private String first_name;
    private String last_name;
    private double indicative;
    private String document;
    private double phone;
    private String email;
    private String address;

}
