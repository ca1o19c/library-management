package com.academy.librarymanagement.application;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("library-management/v1/books")
public class LibraryController {

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok("Hello Books");
    }
}
