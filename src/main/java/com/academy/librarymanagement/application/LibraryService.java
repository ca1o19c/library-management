package com.academy.librarymanagement.application;

import com.academy.librarymanagement.domain.BookSearch;
import com.academy.librarymanagement.domain.Book;
import com.academy.librarymanagement.domain.FilteredBook;
import com.academy.librarymanagement.ports.in.LibraryInbound;
import com.academy.librarymanagement.ports.in.MongoOperationsInbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class LibraryService implements LibraryInbound {

    @Autowired
    private MongoOperationsInbound mongoOperationsInbound;

    @Override
    public FilteredBook findAll(BookSearch search) {
        return mongoOperationsInbound.findAll(search);
    }

    @Override
    public Book findOne(String id) {
        return mongoOperationsInbound.findOne(id);
    }

    @Override
    public void save(Book book) {
        mongoOperationsInbound.save(book);
    }

    @Override
    public void findByTitle() {

    }
}
