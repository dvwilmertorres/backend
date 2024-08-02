package com.appmatch.msusuarios.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "knowledge", schema = "appmatch_schema")
@Data
public class knowledgeEntity {
    @Id
    @Column(name = "pkid_knowledge")
    private UUID id;
    @Column(name = "group_knowledge")
    private String group_knowledge;
    @Column(name = "name_knowledge")
    private String name_knowledge;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getGroup_knowledge() {
        return group_knowledge;
    }

    public void setGroup_knowledge(String group_knowledge) {
        this.group_knowledge = group_knowledge;
    }

    public String getName_knowledge() {
        return name_knowledge;
    }

    public void setName_knowledge(String name_knowledge) {
        this.name_knowledge = name_knowledge;
    }
}
