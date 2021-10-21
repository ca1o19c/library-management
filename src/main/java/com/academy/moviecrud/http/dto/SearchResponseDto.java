package com.academy.moviecrud.http.dto;

import java.util.List;

public class SearchResponseDto<T> {
    private Integer page;

    private Integer perPage;

    private Integer total;

    private Integer totalPages;

    private List<T> result;

    public SearchResponseDto() {
    }

    public SearchResponseDto(Integer total, Integer totalPages, List<T> result) {
        this.total = total;
        this.totalPages = totalPages;
        this.result = result;
    }

    public Integer getPage() {
        return page;
    }

    public SearchResponseDto<T> setPage(Integer page) {
        this.page = page;
        return this;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public SearchResponseDto<T> setPerPage(Integer perPage) {
        this.perPage = perPage;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public SearchResponseDto<T> setTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public SearchResponseDto<T> setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    public List<T> getResult() {
        return result;
    }

    public SearchResponseDto<T> setResult(List<T> result) {
        this.result = result;
        return this;
    }

    @Override
    public String toString() {
        return "SearchResponseDto{" +
                "page=" + page +
                ", perPage=" + perPage +
                ", total=" + total +
                ", totalPages=" + totalPages +
                ", result=" + result +
                '}';
    }
}
