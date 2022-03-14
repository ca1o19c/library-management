package com.academy.librarymanagement.ports.out;

import com.academy.librarymanagement.adapters.in.dto.BookSearchRequest;
import com.academy.librarymanagement.adapters.out.ResearchedBook;

public interface MongoDatabaseStoreOutbound {
    ResearchedBook findAll(BookSearchRequest search);
}
