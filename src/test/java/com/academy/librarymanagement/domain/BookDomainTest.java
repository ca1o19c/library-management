package com.academy.librarymanagement.domain;

import com.academy.librarymanagement.mock.BookMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Book Test")
class BookDomainTest {

    private final Book book = new Book();

    @Test
    void shouldRetrieveCreatedDateTime() {
        var createdDateTime = book.created();

        assertNotNull(createdDateTime.getCreatedOn());
    }

    @Test
    void shouldRetrieveUpdatedDateTimeAndData() {
        var bookMock = BookMock.aMock();

        var updatedDateTime = book.updated(bookMock);

        assertNotNull(updatedDateTime.getUpdatedOn());

        assertEquals("Harry Potter", bookMock.getTitle());
        assertEquals("Rocco", bookMock.getPublisher());
        assertEquals("https://i.imgur.com/UH3IPXw.jpg", bookMock.getImage());
        assertEquals("JK Rowling", bookMock.getWriters().get(0));
    }
}
