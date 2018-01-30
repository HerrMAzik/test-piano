package com.home.project.model;

import com.home.project.model.stack_exchange.SearchResult;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

public class SearchResponse {

    private List<SearchItem> items;

    private int totalItemCount;

    public int getTotalItemCount() {
        return totalItemCount;
    }

    public void setTotalItemCount(int totalItemCount) {
        this.totalItemCount = totalItemCount;
    }

    public List<SearchItem> getItems() {
        return items;
    }

    public SearchResponse(List<SearchItem> items, int totalItemCount) {
        this.items = items;
        this.totalItemCount = totalItemCount;
    }

    public static SearchResponse from(SearchResult searchResult) {

        List<SearchItem> items = searchResult.getItems().stream().map(q -> {
            SearchItem item = new SearchItem();

            item.setAnswerCount(q.getAnswerCount());
            item.setCreationDate(LocalDateTime.ofEpochSecond(q.getCreationDate(), 0, ZoneOffset.UTC));
            item.setLink(q.getLink());
            item.setTitle(q.getTitle());
            item.setPublisherName(q.getOwner().getName());
            item.setPublisherLink(q.getOwner().getLink());
            item.setPublisherImage(q.getOwner().getImage());
            item.setAnswerAccepted(q.getAcceptedAnswerId() != null);

            return item;
        }).collect(Collectors.toList());

        return new SearchResponse(items, searchResult.getTotalItems());
    }
}
