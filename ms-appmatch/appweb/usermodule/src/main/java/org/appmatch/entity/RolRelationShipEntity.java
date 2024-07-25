package org.appmatch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "role_relationship", schema = "appmatch_schema")
public class RolRelationShipEntity {
    @Id
    private Long pkid_role_relationship;
    private String creation_date;
    private String expiration_date;
    private Long fk_pkid_login_user;
    private Long fk_pkid_user_rol;
}
