package com.appmatch.msusuarios.model;


public class CredentialDto {

    private String username;
    private String password;
    private String fk_pkid_user_Profile;
    private String number_attempts;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFk_pkid_user_Profile() {
        return fk_pkid_user_Profile;
    }

    public void setFk_pkid_user_Profile(String fk_pkid_user_Profile) {
        this.fk_pkid_user_Profile = fk_pkid_user_Profile;
    }

    public String getNumber_attempts() {
        return number_attempts;
    }

    public void setNumber_attempts(String number_attempts) {
        this.number_attempts = number_attempts;
    }
}
