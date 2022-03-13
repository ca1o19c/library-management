package com.academy.librarymanagement.ports.in;

import com.academy.librarymanagement.domain.BookAggregate;

import java.util.List;

public interface MongoOperationsInbound {
    List<BookAggregate> findAll();
}
