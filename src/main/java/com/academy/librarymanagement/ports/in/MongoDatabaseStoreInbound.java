package com.academy.librarymanagement.ports.in;

import com.academy.librarymanagement.adapters.out.Book;

import java.util.List;

public interface MongoDatabaseStoreInbound {
    List<Book> findAll();
}
