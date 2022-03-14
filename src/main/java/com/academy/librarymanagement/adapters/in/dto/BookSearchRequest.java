package com.academy.librarymanagement.adapters.in.dto;

import com.academy.librarymanagement.domain.SortType;

import java.time.LocalDate;

public class BookSearchRequest {

    private String title;
    private String publisher;
    private Integer page;
    private Integer limit;
    private LocalDate initialDate;
    private LocalDate finalDate;
    private SortType sortType;

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String title;
        private String publisher;
        private Integer page;
        private Integer limit;
        private LocalDate initialDate;
        private LocalDate finalDate;
        private SortType sortType;

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withPublisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public Builder withPage(Integer page) {
            this.page = page;
            return this;
        }

        public Builder withLimit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public Builder withInitialDate(LocalDate createOn) {
            this.initialDate = createOn;
            return this;
        }

        public Builder withFinalDate(LocalDate updatedOn) {
            this.finalDate = updatedOn;
            return this;
        }

        public Builder withSortType(SortType sortType) {
            this.sortType = sortType;
            return this;
        }

        public BookSearchRequest build() {
            BookSearchRequest bookSearchRequest = new BookSearchRequest();
            bookSearchRequest.title = this.title;
            bookSearchRequest.page = this.page;
            bookSearchRequest.finalDate = this.finalDate;
            bookSearchRequest.limit = this.limit;
            bookSearchRequest.sortType = this.sortType;
            bookSearchRequest.initialDate = this.initialDate;
            bookSearchRequest.publisher = this.publisher;
            return bookSearchRequest;
        }
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getLimit() {
        return limit;
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public SortType getSortType() {
        return sortType;
    }
}
