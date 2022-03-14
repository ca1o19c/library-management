package com.academy.librarymanagement.adapters.in.dto;

import java.util.List;

public class PageResponse<BookResponse> {
    private final List<BookResponse> books;

    private final Integer page;

    private final Integer limit;

    private final Integer total;

    public PageResponse(List<BookResponse> books, Integer page, Integer limit, Integer total) {
        this.books = books;
        this.page = page;
        this.limit = limit;
        this.total = total;
    }

    public List<BookResponse> getBooks() {
        return books;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getLimit() {
        return limit;
    }

    public Integer getTotal() {
        return total;
    }
}
