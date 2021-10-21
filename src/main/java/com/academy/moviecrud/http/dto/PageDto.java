package com.academy.moviecrud.http.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"page", "per_page", "total_pages", "total", "data"})
@JsonNaming(SnakeCaseStrategy.class)
public class PageDto<T> {
    private Integer page;

    private Integer perPage;

    private Integer totalPages;

    private Integer total;

    private List<T> data;

    public PageDto(Integer page,
                   Integer perPage,
                   Integer totalPages,
                   Integer total,
                   List<T> data) {
        this.page = page;
        this.perPage = perPage;
        this.totalPages = totalPages;
        this.total = total;
        this.data = data;
    }

    public Integer getPage() {
        return page;
    }

    public PageDto<T> setPage(Integer page) {
        this.page = page;
        return this;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public PageDto<T> setPerPage(Integer perPage) {
        this.perPage = perPage;
        return this;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public PageDto<T> setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public PageDto<T> setTotal(Integer total) {
        this.total = total;
        return this;
    }

    public List<T> getData() {
        if (CollectionUtils.isEmpty(this.data)) {
            this.data = new ArrayList<>();
        }
        return data;
    }

    public PageDto<T> setData(List<T> data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "PageDto{" +
                "page=" + page +
                ", perPage=" + perPage +
                ", totalPages=" + totalPages +
                ", total=" + total +
                ", data=" + data +
                '}';
    }
}
