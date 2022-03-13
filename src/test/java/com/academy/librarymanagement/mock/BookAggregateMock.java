package com.academy.librarymanagement.mock;

import com.academy.librarymanagement.domain.Book;

public class BookAggregateMock {
    public static Book aMock() {
        return Book.builder().build();
    }
}