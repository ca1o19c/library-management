package com.academy.librarymanagement.adapters.out;

import com.academy.librarymanagement.adapters.config.exception.BookNotFoundException;
import com.academy.librarymanagement.domain.BookSearch;
import com.academy.librarymanagement.domain.FilteredBook;
import com.academy.librarymanagement.ports.out.MongoDatabaseStorePortOutbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class MongoDatabaseStore implements MongoDatabaseStorePortOutbound {

    @Autowired
    private MongoDBOperations mongoDBOperations;

    @Override
    public FilteredBook findAll(BookSearch search) {
        ResearchedBook books = mongoDBOperations.findAll(search);

        return buildBookAggregate(books);
    }

    @Override
    public void save(com.academy.librarymanagement.domain.Book book) {
        mongoDBOperations.save(book);
    }

    @Override
    public com.academy.librarymanagement.domain.Book findOne(String id) {
        com.academy.librarymanagement.adapters.out.Book book = mongoDBOperations.findOne(id).orElseThrow(() -> new BookNotFoundException("Book not found"));

        return com.academy.librarymanagement.domain.Book.builder()
                .withId(book.getId())
                .withTitle(book.getTitle())
                .withImage(book.getImage())
                .withPublisher(book.getPublisher())
                .withWriters(book.getWriters())
                .withCreatedOn(book.getCreatedOn())
                .withUpdatedOn(book.getUpdatedOn())
                .build();
    }

    @Override
    public void deleteOne(String id) {
        mongoDBOperations.deleteOne(id).orElseThrow(() -> new BookNotFoundException("Book not found"));
    }

    private FilteredBook buildBookAggregate(ResearchedBook books) {

        com.academy.librarymanagement.domain.Book.Builder bookBuilder = com.academy.librarymanagement.domain.Book.builder();

        List<com.academy.librarymanagement.domain.Book> listBooks = new ArrayList<>();

        books.getResult().forEach(book -> {
                    bookBuilder
                            .withId(book.getId())
                            .withImage(book.getImage())
                            .withPublisher(book.getPublisher())
                            .withTitle(book.getTitle())
                            .withWriters(book.getWriters())
                            .withCreatedOn(book.getCreatedOn())
                            .withUpdatedOn(book.getUpdatedOn());

                    listBooks.add(bookBuilder.build());
                }
        );

        return FilteredBook.builder()
                .withBooks(listBooks)
                .withTotal(books.getTotal())
                .build();
    }
}
