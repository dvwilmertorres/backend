package com.appmatch.msusuarios.model;

public class UserSesionCredentialsDto {
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFk_pkid_user_information() {
        return fk_pkid_user_information;
    }

    public void setFk_pkid_user_information(String fk_pkid_user_information) {
        this.fk_pkid_user_information = fk_pkid_user_information;
    }

    public String getNumber_attempts() {
        return number_attempts;
    }

    public void setNumber_attempts(String number_attempts) {
        this.number_attempts = number_attempts;
    }

    private Long pkid_user;
    private String creation_date;
    private String expiration_date;
    private String user;
    private String password;
    private String fk_pkid_user_information;
    private String number_attempts;
}
