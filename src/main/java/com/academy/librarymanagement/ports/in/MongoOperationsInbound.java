package com.academy.librarymanagement.ports.in;

import com.academy.librarymanagement.adapters.in.dto.BookSearchRequest;
import com.academy.librarymanagement.domain.Book;
import com.academy.librarymanagement.domain.FilteredBook;

public interface MongoOperationsInbound {
    FilteredBook findAll(BookSearchRequest search);
    void save(Book book);
}
