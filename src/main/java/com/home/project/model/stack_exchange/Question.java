package com.home.project.model.stack_exchange;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Question {
    private int answerCount;
    private String title;
    private String link;
    private Long creationDate;
    private User owner;
    private Integer acceptedAnswerId;

    public Integer getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    @JsonProperty("accepted_answer_id")
    public void setAcceptedAnswerId(Integer acceptedAnswerId) {
        this.acceptedAnswerId = acceptedAnswerId;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    @JsonProperty("answer_count")
    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
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

    public Long getCreationDate() {
        return creationDate;
    }

    @JsonProperty("creation_date")
    public void setCreationDate(Long creationDate) {
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
