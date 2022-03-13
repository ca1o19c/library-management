package com.academy.librarymanagement.ports.in;

import com.academy.librarymanagement.domain.Book;

import java.util.List;

public interface LibraryInbound {
    List<Book> findAll();
    void findOne();
    void save();
    void findByTitle();
}
