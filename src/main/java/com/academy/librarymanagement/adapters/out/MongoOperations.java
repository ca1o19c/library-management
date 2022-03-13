package com.academy.librarymanagement.adapters.out;

import com.academy.librarymanagement.domain.Book;
import com.academy.librarymanagement.ports.out.MongoDatabaseStoreOutbound;
import com.academy.librarymanagement.ports.in.MongoOperationsInbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class MongoOperations implements MongoOperationsInbound {

    @Autowired
    private MongoDatabaseStoreOutbound mongoDatabaseStoreOutbound;

    @Override
    public List<Book> findAll() {
        List<com.academy.librarymanagement.adapters.out.Book> books = mongoDatabaseStoreOutbound.findAll();

        return buildBookAggregate(books);
    }

    private List<Book> buildBookAggregate(List<com.academy.librarymanagement.adapters.out.Book> books) {

        Book.Builder bookBuilder = Book.builder();

        List<Book> listBooks = new ArrayList<>();

        books.forEach(book -> {
                    bookBuilder
                            .withId(book.getId())
                            .withImage(book.getImage())
                            .withPublisher(book.getPublisher())
                            .withTitle(book.getTitle())
                            .withWriters(book.getWriters())
                            .withCreatedOn(book.getCreatedOn())
                            .withUpdatedOn(book.getCreatedOn());

                    listBooks.add(bookBuilder.build());
                }
        );

        return listBooks;
    }
}
