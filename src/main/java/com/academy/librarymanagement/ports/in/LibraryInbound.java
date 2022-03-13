package com.academy.librarymanagement.ports.in;

import com.academy.librarymanagement.domain.BookAggregate;

import java.util.List;

public interface LibraryInbound {
    List<BookAggregate> findAll();
    void findOne();
    void save();
    void findByTitle();
}
