package org.appmatch.model;

public class UserSessionInfoDto {
    private Long pkid_user;

    private String username;
    private String name;
    public Long getPkid_user() {
        return pkid_user;
    }

    public void setPkid_user(Long pkid_user) {
        this.pkid_user = pkid_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
