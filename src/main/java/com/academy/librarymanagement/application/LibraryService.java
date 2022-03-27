package com.academy.librarymanagement.application;

import com.academy.librarymanagement.domain.Book;
import com.academy.librarymanagement.domain.BookSearch;
import com.academy.librarymanagement.domain.FilteredBook;
import com.academy.librarymanagement.ports.in.LibraryPortInbound;
import com.academy.librarymanagement.ports.out.MongoDatabaseStorePortOutbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class LibraryService implements LibraryPortInbound {

    @Autowired
    private MongoDatabaseStorePortOutbound mongoDatabaseStorePortOutbound;

    @Override
    public FilteredBook findAll(BookSearch search) {
        return mongoDatabaseStorePortOutbound.findAll(search);
    }

    @Override
    public Book findOne(String id) {
        return mongoDatabaseStorePortOutbound.findOne(id);
    }

    @Override
    public void save(Book book) {
        mongoDatabaseStorePortOutbound.save(book);
    }

    @Override
    public void updateOne() {

    }

    @Override
    public void deleteOne(String id) {
        mongoDatabaseStorePortOutbound.deleteOne(id);
    }
}
