package com.academy.librarymanagement.ports.out;

import com.academy.librarymanagement.domain.BookSearch;
import com.academy.librarymanagement.adapters.out.ResearchedBook;
import com.academy.librarymanagement.domain.Book;

public interface MongoDatabaseStoreOutbound {
    ResearchedBook findAll(BookSearch search);
    void save(Book book);
}
