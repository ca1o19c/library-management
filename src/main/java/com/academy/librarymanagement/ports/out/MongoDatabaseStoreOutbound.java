package com.academy.librarymanagement.ports.out;

import com.academy.librarymanagement.adapters.out.Book;

import java.util.List;

public interface MongoDatabaseStoreOutbound {
    List<Book> findAll();
}
