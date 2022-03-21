package com.academy.librarymanagement.adapters.out;

import com.academy.librarymanagement.adapters.config.exception.BookNotFoundException;
import com.academy.librarymanagement.domain.BookSearch;
import com.academy.librarymanagement.domain.Book;
import com.academy.librarymanagement.domain.FilteredBook;
import com.academy.librarymanagement.ports.in.MongoOperationsInbound;
import com.academy.librarymanagement.ports.out.MongoDatabaseStoreOutbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class MongoOperations implements MongoOperationsInbound {

    @Autowired
    private MongoDatabaseStoreOutbound mongoDatabaseStoreOutbound;

    @Override
    public FilteredBook findAll(BookSearch search) {
        ResearchedBook books = mongoDatabaseStoreOutbound.findAll(search);

        return buildBookAggregate(books);
    }

    @Override
    public void save(Book book) {
        mongoDatabaseStoreOutbound.save(book);
    }

    @Override
    public Book findOne(String id) {
        com.academy.librarymanagement.adapters.out.Book book = mongoDatabaseStoreOutbound.findOne(id).orElseThrow(() -> new BookNotFoundException("Book with id " + id + " not found"));

        return Book.builder()
                .withId(book.getId())
                .withTitle(book.getTitle())
                .withImage(book.getImage())
                .withPublisher(book.getPublisher())
                .withWriters(book.getWriters())
                .withCreatedOn(book.getCreatedOn())
                .withUpdatedOn(book.getUpdatedOn())
                .build();
    }

    private FilteredBook buildBookAggregate(ResearchedBook books) {

        Book.Builder bookBuilder = Book.builder();

        List<Book> listBooks = new ArrayList<>();

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
