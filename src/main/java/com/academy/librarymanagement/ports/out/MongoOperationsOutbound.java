package com.academy.librarymanagement.ports.out;

import com.academy.librarymanagement.domain.BookAggregate;

import java.util.List;

public interface MongoOperationsOutbound {
    List<BookAggregate> findAll();
}
