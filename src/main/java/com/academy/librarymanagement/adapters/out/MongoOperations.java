package com.academy.librarymanagement.adapters.out;

import com.academy.librarymanagement.adapters.in.dto.BookSearchRequest;
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
    public FilteredBook findAll(BookSearchRequest search) {
        ResearchedBook books = mongoDatabaseStoreOutbound.findAll(search);

        return buildBookAggregate(books);
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
                            .withUpdatedOn(book.getCreatedOn());

                    listBooks.add(bookBuilder.build());
                }
        );

        return FilteredBook.builder()
                .withBooks(listBooks)
                .withTotal(books.getTotal())
                .build();
    }
}
