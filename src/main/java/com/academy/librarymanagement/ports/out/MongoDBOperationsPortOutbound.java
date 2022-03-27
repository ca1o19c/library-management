package com.academy.librarymanagement.ports.out;

import com.academy.librarymanagement.adapters.out.ResearchedBook;
import com.academy.librarymanagement.domain.Book;
import com.academy.librarymanagement.domain.BookSearch;

import java.util.Optional;

public interface MongoDBOperationsPortOutbound {
    ResearchedBook findAll(BookSearch search);
    void save(Book book);
    Optional<com.academy.librarymanagement.adapters.out.Book> findOne(String id);
    Optional<com.academy.librarymanagement.adapters.out.Book> deleteOne(String id);
}
