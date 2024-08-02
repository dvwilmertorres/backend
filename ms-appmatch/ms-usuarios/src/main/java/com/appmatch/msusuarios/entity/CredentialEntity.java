package com.appmatch.msusuarios.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "user", schema = "appmatch_schema")
@Data
public class CredentialEntity {
    @Id
    @Column(name = "pkId_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID Id;
    @Column(name = "creation_date")
    private String creation_date;
    @Column(name = "expiration_date")
    private String expiration_date;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @Column(name = "fk_pkid_user_profile", unique = true)
    private UUID fkPkidUserProfile;
    @Column(name = "number_attempts")
    private int number_attempts;

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
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

    public UUID getFkPkidUserProfile() {
        return fkPkidUserProfile;
    }

    public void setFkPkidUserProfile(UUID fkPkidUserProfile) {
        this.fkPkidUserProfile = fkPkidUserProfile;
    }

    public int getNumber_attempts() {
        return number_attempts;
    }

    public void setNumber_attempts(int number_attempts) {
        this.number_attempts = number_attempts;
    }
}
