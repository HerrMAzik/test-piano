package com.home.project.model;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

public class SearchResponse {

    private List<SearchItem> items;

    private int totalItemsCount;
    private int currentPage;
    private int pageSize;

    public SearchResponse(@NotNull List<SearchItem> items) {
        if (items == null)
            throw new NullPointerException("items must not be null");
        this.items = items;
    }

    public List<SearchItem> getItems() {
        return items;
    }

    public int getTotalItemsCount() {
        return totalItemsCount;
    }

    public void setTotalItemsCount(int totalItemsCount) {
        this.totalItemsCount = totalItemsCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchResponse that = (SearchResponse) o;
        return totalItemsCount == that.totalItemsCount &&
                currentPage == that.currentPage &&
                pageSize == that.pageSize &&
                items.equals(that.items);
    }

    @Override
    public int hashCode() {

        return Objects.hash(items, totalItemsCount, currentPage, pageSize);
    }
}
