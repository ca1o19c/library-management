package com.academy.librarymanagement.domain;

import com.academy.librarymanagement.mock.BookMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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

        var updatedDateTime = bookMock.update(bookMock);

        assertThat(updatedDateTime)
                .isNotNull()
                .isEqualTo(bookMock);
    }
}
