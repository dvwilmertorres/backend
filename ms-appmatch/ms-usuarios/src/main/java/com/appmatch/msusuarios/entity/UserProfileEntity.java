package com.appmatch.msusuarios.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "user_profile", schema = "appmatch_schema")
@Data
public class UserProfileEntity {
    @Id
    @Column(name = "pkid_user_profile")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID pkid_user_profile;
    @Column(name = "creation_date", updatable = false, nullable = false)
    @CreationTimestamp
    private String creationDate;

    public UUID getPkid_user_profile() {
        return pkid_user_profile;
    }

    public void setPkid_user_profile(UUID pkid_user_profile) {
        this.pkid_user_profile = pkid_user_profile;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Column(name = "expiration_date")
    private String expirationDate;
    @Column(name = "fk_pkid_dictionary_id_type")
    private UUID fk_pkid_dictionary_id_type;
    @Column(name = "identification_number")
    private String identification_number;
    @Column(name = "name")
    private String name;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "fathers_last_name")
    private String fathersLastName;
    @Column(name = "mothers_last_name")
    private String mothersLastName;
    @Column(name = "birthdate")
    private String birthdate;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "fk_pkid_dictionary_gender")
    private UUID fk_pkid_dictionary_gender;
    @Column(name = "fk_pkid_dictionary_country_birth")
    private UUID fk_pkid_dictionary_country_birth;
    @Column(name = "image")
    private String image;

    public UUID getId() {
        return pkid_user_profile;
    }

    public void setId(UUID id) {
        pkid_user_profile = id;
    }

    public UUID getFk_pkid_dictionary_id_type() {
        return fk_pkid_dictionary_id_type;
    }

    public void setFk_pkid_dictionary_id_type(UUID fk_pkid_dictionary_id_type) {
        this.fk_pkid_dictionary_id_type = fk_pkid_dictionary_id_type;
    }

    public String getIdentification_number() {
        return identification_number;
    }

    public void setIdentification_number(String identification_number) {
        this.identification_number = identification_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFathersLastName() {
        return fathersLastName;
    }

    public void setFathersLastName(String fathersLastName) {
        this.fathersLastName = fathersLastName;
    }

    public String getMothersLastName() {
        return mothersLastName;
    }

    public void setMothersLastName(String mothersLastName) {
        this.mothersLastName = mothersLastName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
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

    public UUID getFk_pkid_dictionary_gender() {
        return fk_pkid_dictionary_gender;
    }

    public void setFk_pkid_dictionary_gender(UUID fk_pkid_dictionary_gender) {
        this.fk_pkid_dictionary_gender = fk_pkid_dictionary_gender;
    }

    public UUID getFk_pkid_dictionary_country_birth() {
        return fk_pkid_dictionary_country_birth;
    }

    public void setFk_pkid_dictionary_country_birth(UUID fk_pkid_dictionary_country_birth) {
        this.fk_pkid_dictionary_country_birth = fk_pkid_dictionary_country_birth;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
