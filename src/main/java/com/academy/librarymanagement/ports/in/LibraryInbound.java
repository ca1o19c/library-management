package com.academy.librarymanagement.ports.in;

import com.academy.librarymanagement.adapters.in.dto.BookSearchRequest;
import com.academy.librarymanagement.domain.Book;
import com.academy.librarymanagement.domain.FilteredBook;

public interface LibraryInbound {
    FilteredBook findAll(BookSearchRequest search);
    void findOne();
    void save(Book book);
    void findByTitle();
}
