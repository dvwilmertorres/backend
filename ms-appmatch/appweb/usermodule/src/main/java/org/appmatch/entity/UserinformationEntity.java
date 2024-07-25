package org.appmatch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_information", schema = "appmatch_schema")
public class UserinformationEntity {
    @Id
    private Long pkid_user_infromation;
    private String creation_date;
    private String expiration_date;
    private String first_name;
    private String last_name;
    private Long indicative;
    private Number phone;
    private String email;
    private String addres;
}
