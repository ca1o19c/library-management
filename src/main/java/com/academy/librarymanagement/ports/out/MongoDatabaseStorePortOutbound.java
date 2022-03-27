package com.academy.librarymanagement.ports.out;

import com.academy.librarymanagement.adapters.out.ResearchedBook;
import com.academy.librarymanagement.domain.Book;
import com.academy.librarymanagement.domain.BookSearch;
import com.academy.librarymanagement.domain.FilteredBook;

import java.util.Optional;

public interface MongoDatabaseStorePortOutbound {
    FilteredBook findAll(BookSearch search);
    void save(Book book);
    Book findOne(String id);
    void deleteOne(String id);
}
