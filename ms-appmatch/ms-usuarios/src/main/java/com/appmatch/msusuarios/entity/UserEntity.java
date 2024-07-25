package com.appmatch.msusuarios.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@Table(name = "user", schema = "appmatch_schema")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkid_user;
    private String creation_date;
    private String expiration_date;
    private String user;
    private String password;
    private int number_attempts;
    private Long fk_pkid_user_information;
}
