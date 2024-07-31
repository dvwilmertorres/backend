package com.appmatch.msproduct.model;

public class KnowledgeDto {
    private String id;
    private String knowledge;
    private String price;
    private int rating;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public KnowledgeDto(String id, String knowledge, String price, int rating) {
        this.id = id;
        this.knowledge = knowledge;
        this.price = price;
        this.rating = rating;
    }

}
