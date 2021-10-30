package com.academy.librarymanagement.infra.crosscutting;

import com.academy.librarymanagement.domain.Book;
import com.academy.librarymanagement.services.LibraryService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class LibraryActions {

    private final LibraryService libraryService;

    public LibraryActions(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public URI getLocation(String id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }

    public String createOneBook(Book book) {
        var createAtMongo = this.libraryService.createOne(book);
        return createAtMongo.getId();
    }
}
