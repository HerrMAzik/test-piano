package com.home.project.model;

public class SearchRequest {
    private String title;
    private int page;
    private int pageSize;

    public SearchRequest() {
        page = 1;
        pageSize = 10;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
