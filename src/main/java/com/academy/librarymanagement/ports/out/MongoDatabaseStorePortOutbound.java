package com.academy.librarymanagement.ports.out;

import com.academy.librarymanagement.domain.Book;
import com.academy.librarymanagement.domain.BookSearch;
import com.academy.librarymanagement.domain.FilteredBook;

public interface MongoDatabaseStorePortOutbound {
    FilteredBook findAll(BookSearch search);
    void save(Book book);
    Book findOne(String id);
    void deleteOne(String id);
}
