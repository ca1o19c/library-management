package com.academy.librarymanagement.adapters.out;

import java.util.List;

public class ResearchedBook {
    private final Integer total;

    private final List<com.academy.librarymanagement.adapters.out.Book> result;

    public ResearchedBook(Integer total, List<com.academy.librarymanagement.adapters.out.Book> result) {
        this.total = total;
        this.result = result;
    }

    public Integer getTotal() {
        return total;
    }

    public List<Book> getResult() {
        return result;
    }
}
