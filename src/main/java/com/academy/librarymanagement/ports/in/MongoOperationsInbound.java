package com.academy.librarymanagement.ports.in;

import com.academy.librarymanagement.domain.Book;

import java.util.List;

public interface MongoOperationsInbound {
    List<Book> findAll();
}
