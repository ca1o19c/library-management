package com.academy.librarymanagement.ports.in;

import com.academy.librarymanagement.domain.BookSearch;
import com.academy.librarymanagement.domain.Book;
import com.academy.librarymanagement.domain.FilteredBook;

public interface LibraryInbound {
    FilteredBook findAll(BookSearch search);
    void findOne();
    void save(Book book);
    void findByTitle();
}
