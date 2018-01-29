package com.home.project.model;

import java.time.LocalDateTime;

public class SearchItem {
    private int answerCount;
    private String title;
    private String link;
    private LocalDateTime creationDate;
    private String publisherName;
    private String publisherImage;
    private String publisherLink;
    private boolean isAnswerAccepted;

    public boolean isAnswerAccepted() {
        return isAnswerAccepted;
    }

    public void setAnswerAccepted(boolean answerAccepted) {
        isAnswerAccepted = answerAccepted;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherImage() {
        return publisherImage;
    }

    public void setPublisherImage(String publisherImage) {
        this.publisherImage = publisherImage;
    }

    public String getPublisherLink() {
        return publisherLink;
    }

    public void setPublisherLink(String publisherLink) {
        this.publisherLink = publisherLink;
    }
}
