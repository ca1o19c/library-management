package com.academy.librarymanagement.adapters.out;

import com.academy.librarymanagement.domain.BookAggregate;
import com.academy.librarymanagement.ports.in.MongoDatabaseStoreInbound;
import com.academy.librarymanagement.ports.out.MongoOperationsOutbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class MongoOperations implements MongoOperationsOutbound {

    @Autowired
    private MongoDatabaseStoreInbound mongoDatabaseStoreInbound;

    @Override
    public List<BookAggregate> findAll() {
        List<Book> books = mongoDatabaseStoreInbound.findAll();

        return buildBookAggregate(books);
    }

    private List<BookAggregate> buildBookAggregate(List<Book> books) {

        BookAggregate.Builder bookBuilder = BookAggregate.builder();

        List<BookAggregate> bookAggregates = new ArrayList<>();

        books.forEach(book -> {
                    bookBuilder
                            .withId(book.getId())
                            .withImage(book.getImage())
                            .withPublisher(book.getPublisher())
                            .withTitle(book.getTitle())
                            .withWriters(book.getWriters())
                            .withCreatedOn(book.getCreatedOn())
                            .withUpdatedOn(book.getCreatedOn());

                    bookAggregates.add(bookBuilder.build());
                }
        );

        return bookAggregates;
    }
}
