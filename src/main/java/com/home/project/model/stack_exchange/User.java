package com.home.project.model.stack_exchange;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private int id;
    private String name;
    private String image;
    private String link;

    public int getId() {
        return id;
    }

    @JsonProperty("user_id")
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @JsonProperty("display_name")
    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    @JsonProperty("profile_image")
    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }
}
