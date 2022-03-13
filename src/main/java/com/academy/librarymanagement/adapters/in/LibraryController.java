package com.academy.librarymanagement.adapters.in;

import com.academy.librarymanagement.adapters.in.dto.BookResponse;
import com.academy.librarymanagement.domain.Book;
import com.academy.librarymanagement.ports.in.LibraryInbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/books")
public class LibraryController {

    @Autowired
    LibraryInbound libraryInbound;

    @GetMapping
    public ResponseEntity<List<BookResponse>> findAll() {
        List<Book> books = libraryInbound.findAll();

        var payload = books
                .stream()
                .map(BookResponse::from)
                .collect(Collectors.toList());

        return ResponseEntity.ok(payload);
    }
}
