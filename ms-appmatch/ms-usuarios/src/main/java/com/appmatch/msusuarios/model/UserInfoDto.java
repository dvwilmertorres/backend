package com.appmatch.msusuarios.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class UserInfoDto {
    private Long pkid_user_information;
    private String creation_date;
    private String expiration_date;
    private String first_name;

    public Long getPkid_user_information() {
        return pkid_user_information;
    }

    public void setPkid_user_information(Long pkid_user_information) {
        this.pkid_user_information = pkid_user_information;
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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
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

    private String document;
    private String last_name;
    private double indicative;
    private double phone;
    private String email;
    private String address;
}
