package com.appmatch.msproduct.model;

import java.util.List;

public class GroupedProductDto {
    private String name;
    private String userId;
    private String image;
    private List<KnowledgeDto> knowledge;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<KnowledgeDto> getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(List<KnowledgeDto> knowledge) {
        this.knowledge = knowledge;
    }

    public GroupedProductDto(String name, String userId, String image, List<KnowledgeDto> knowledge) {
        this.name = name;
        this.userId = userId;
        this.image = image;
        this.knowledge = knowledge;
    }

}
