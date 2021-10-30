package com.academy.librarymanagement.application;

import com.academy.librarymanagement.domain.Library;
import com.academy.librarymanagement.services.LibraryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("library-management/v1/books")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(final LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public ResponseEntity<Page<Library>> findAll(Pageable pageable) {
        var body = libraryService.findAll(pageable);
        return ResponseEntity.ok(body);
    }
}
