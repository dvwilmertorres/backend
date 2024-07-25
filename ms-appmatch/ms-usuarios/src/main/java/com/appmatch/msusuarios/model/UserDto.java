package com.appmatch.msusuarios.model;

public class UserDto {
    public Long getPkid_user() {
        return pkid_user;
    }

    public void setPkid_user(Long pkid_user) {
        this.pkid_user = pkid_user;
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

    private Long pkid_user;
    private String user;
    private String password;
}
