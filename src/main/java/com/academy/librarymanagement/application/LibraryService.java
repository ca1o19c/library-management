package com.academy.librarymanagement.application;

import com.academy.librarymanagement.domain.Book;
import com.academy.librarymanagement.ports.in.LibraryInbound;
import com.academy.librarymanagement.ports.in.MongoOperationsInbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class LibraryService implements LibraryInbound {

    @Autowired
    MongoOperationsInbound mongoOperationsInbound;

    @Override
    public List<Book> findAll() {
        return mongoOperationsInbound.findAll();
    }

    @Override
    public void findOne() {

    }

    @Override
    public void save() {

    }

    @Override
    public void findByTitle() {

    }
}
