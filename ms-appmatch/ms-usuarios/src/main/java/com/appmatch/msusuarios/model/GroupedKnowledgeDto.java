package com.appmatch.msusuarios.model;

import java.util.UUID;

public class GroupedKnowledgeDto {
    private UUID id;

    private String group_knowledge;

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
