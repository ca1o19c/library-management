package com.academy.librarymanagement.ports.in;

import com.academy.librarymanagement.domain.BookSearch;
import com.academy.librarymanagement.domain.Book;
import com.academy.librarymanagement.domain.FilteredBook;

public interface MongoOperationsInbound {
    FilteredBook findAll(BookSearch search);
    void save(Book book);

    Book findOne(String id);
}
