package com.academy.librarymanagement.ports.out;

import com.academy.librarymanagement.adapters.in.dto.BookSearchRequest;
import com.academy.librarymanagement.adapters.out.ResearchedBook;
import com.academy.librarymanagement.domain.Book;

public interface MongoDatabaseStoreOutbound {
    ResearchedBook findAll(BookSearchRequest search);
    void save(Book book);
}
