package com.home.project.model.stack_exchange;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SearchResult {
    private List<Question> items = Collections.emptyList();

    private int totalItems;
    private int page;
    private int pageSize;

    public List<Question> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Question> items) {
        this.items = items;
    }

    public int getTotalItems() {
        return totalItems;
    }

    @JsonProperty("total")
    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    @JsonProperty("page_size")
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public static SearchResult empty(){
        SearchResult searchResult = new SearchResult();
        searchResult.totalItems = 0;
        searchResult.page = 1;
        searchResult.pageSize = 0;

        return searchResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchResult that = (SearchResult) o;
        return totalItems == that.totalItems &&
                page == that.page &&
                pageSize == that.pageSize &&
                Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {

        return Objects.hash(items, totalItems, page, pageSize);
    }
}
