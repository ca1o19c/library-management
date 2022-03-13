package com.academy.librarymanagement.application;

import com.academy.librarymanagement.domain.BookAggregate;
import com.academy.librarymanagement.ports.in.LibraryInbound;
import com.academy.librarymanagement.ports.out.MongoOperationsOutbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class LibraryService implements LibraryInbound {

    @Autowired
    MongoOperationsOutbound mongoOperationsOutbound;

    @Override
    public List<BookAggregate> findAll() {
        return mongoOperationsOutbound.findAll();
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
