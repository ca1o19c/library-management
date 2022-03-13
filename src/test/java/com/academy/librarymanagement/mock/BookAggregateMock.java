package com.academy.librarymanagement.mock;

import com.academy.librarymanagement.adapters.out.Book;
import com.academy.librarymanagement.domain.BookAggregate;

import java.util.List;
import java.util.UUID;

public class BookAggregateMock {
    public static BookAggregate aMock() {
        return BookAggregate.builder().build();
    }
}