package com.home.project.model.StackExchange;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Question {
    private boolean isAnswered;
    private String title;
    private String link;
    private long creationDate;
    private User owner;

    public boolean isAnswered() {
        return isAnswered;
    }

    @JsonProperty("is_answered")
    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    public long getCreationDate() {
        return creationDate;
    }

    @JsonProperty("creation_date")
    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public User getOwner() {
        return owner;
    }

    @JsonProperty("owner")
    public void setOwner(User owner) {
        this.owner = owner;
    }
}
