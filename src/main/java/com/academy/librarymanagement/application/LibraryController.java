package com.academy.librarymanagement.application;

import com.academy.librarymanagement.domain.Book;
import com.academy.librarymanagement.domain.BookDto;
import com.academy.librarymanagement.infra.crosscutting.LibraryActions;
import com.academy.librarymanagement.services.LibraryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("library-management/v1/books")
public class LibraryController {

    private final LibraryService libraryService;
    private final LibraryActions libraryActions;


    public LibraryController(final LibraryService libraryService, final LibraryActions libraryActions) {
        this.libraryService = libraryService;
        this.libraryActions = libraryActions;
    }

    @GetMapping
    public ResponseEntity<Page<Book>> findAll(Pageable pageable) {
        var body = libraryService.findAll(pageable);
        return ResponseEntity.ok(body);
    }

    @PostMapping
    public ResponseEntity<?> createOne(@RequestBody @Valid BookDto bookDto) {
        var id = this.libraryActions.createOneBook(bookDto.toEntity());
        var location = this.libraryActions.getLocation(id);
        return ResponseEntity.created(location).build();
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Book> findOne(@PathVariable String id) {
        return ResponseEntity.ok(libraryService.findOne(id));
    }
}
