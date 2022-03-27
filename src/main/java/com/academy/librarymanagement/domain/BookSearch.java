package com.academy.librarymanagement.domain;

import com.academy.librarymanagement.adapters.config.exception.BadRequestException;

import java.time.LocalDate;

import static java.util.Objects.isNull;

public class BookSearch {

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

        public BookSearch build() {
            BookSearch bookSearch = new BookSearch();
            bookSearch.title = this.title;
            bookSearch.page = this.page;
            bookSearch.finalDate = this.finalDate;
            bookSearch.limit = this.limit;
            bookSearch.sortType = this.sortType;
            bookSearch.initialDate = this.initialDate;
            bookSearch.publisher = this.publisher;
            return bookSearch;
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


    public void verifyIfThePageLessThanZero() {
        if (this.getPage() < 0)
            throw new BadRequestException("Page index must not be less than zero.");
    }

    public void verifyIfTheLimitLessThanZero() {
        if (this.getLimit() < 0)
            throw new BadRequestException("Limit index must not be less than zero.");
    }

    public void verifyIfTheLimitGreaterThanFifty() {
        if (this.getLimit() > 50)
            throw new BadRequestException("Limit index must not be greater than fifty.");
    }

    public void verifyIfTheInitialDateBeforeFinalDate() {
        if (!isNull(this.getInitialDate()) && !isNull(this.getFinalDate()) &&
                this.getFinalDate().isBefore(this.getInitialDate()))
            throw new BadRequestException("initial_date must be before final_date");
    }
}
