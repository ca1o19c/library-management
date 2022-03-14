package com.academy.librarymanagement.domain;

import java.util.List;

public class FilteredBook {
    private Integer total;
    private List<Book> books;

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Integer total;
        private List<Book> books;

        public Builder withTotal(Integer total) {
            this.total = total;
            return this;
        }

        public Builder withBooks(List<Book> books) {
            this.books = books;
            return this;
        }

        public FilteredBook build() {
            FilteredBook filteredBook = new FilteredBook();
            filteredBook.total = this.total;
            filteredBook.books = this.books;
            return filteredBook;
        }
    }

    public Integer getTotal() {
        return total;
    }

    public List<Book> getBooks() {
        return books;
    }
}
