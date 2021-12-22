package com.academy.librarymanagement.mock;

import com.academy.librarymanagement.domain.Book;

import java.util.List;
import java.util.UUID;

public class BookMock {
    public static Book aMock() {
        return new Book()
                .setId(UUID.randomUUID().toString())
                .setTitle("Harry Potter")
                .setImage("https://i.imgur.com/UH3IPXw.jpg")
                .setWriters(List.of("JK Rowling"))
                .setPublisher("Rocco")
                .created();
    }
}