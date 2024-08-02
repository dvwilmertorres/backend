package com.appmatch.msusuarios.model;

public class UserProfileDto {


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;
    private String creation_date;
    private String expiration_date;
    private String fk_pkid_dictionary_id_type;
    private String identification_number;
    private String name;
    private String middleName;
    private String fathersLastName;
    private String mothersLastName;
    private String birthdate;
    private String phone;
    private String email;
    private String address;
    private String fk_pkid_dictionary_gender;
    private String fk_pkid_dictionary_country_birth;
    private String image;

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

    public String getFk_pkid_dictionary_id_type() {
        return fk_pkid_dictionary_id_type;
    }

    public void setFk_pkid_dictionary_id_type(String fk_pkid_dictionary_id_type) {
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

    public String getFk_pkid_dictionary_gender() {
        return fk_pkid_dictionary_gender;
    }

    public void setFk_pkid_dictionary_gender(String fk_pkid_dictionary_gender) {
        this.fk_pkid_dictionary_gender = fk_pkid_dictionary_gender;
    }

    public String getFk_pkid_dictionary_country_birth() {
        return fk_pkid_dictionary_country_birth;
    }

    public void setFk_pkid_dictionary_country_birth(String fk_pkid_dictionary_country_birth) {
        this.fk_pkid_dictionary_country_birth = fk_pkid_dictionary_country_birth;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
