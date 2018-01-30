package com.home.project.model;

import java.util.List;

public class SearchResponse {

    private List<SearchItem> items;

    private int totalItemsCount;
    private int currentPage;
    private int pageSize;

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

    public SearchResponse(List<SearchItem> items) {
        this.items = items;
    }

    public SearchResponse() {
    }
}
