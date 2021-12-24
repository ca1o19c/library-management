package com.academy.librarymanagement.application;

import com.academy.librarymanagement.domain.BookDto;
import com.academy.librarymanagement.infra.crosscutting.LibraryActions;
import com.academy.librarymanagement.services.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<List<BookDto>> findAll() {
        var body = libraryService.findAll();

        var payload = body
                .stream()
                .map(BookDto::from)
                .collect(Collectors.toList());

        return ResponseEntity.ok(payload);
    }

    @PostMapping
    public ResponseEntity<?> createOne(@RequestBody @Valid BookDto bookDto) {
        var id = this.libraryActions.createOneBook(bookDto.toEntity());
        var location = this.libraryActions.getLocation(id);
        return ResponseEntity.created(location).build();
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<BookDto> findOne(@PathVariable String id) {
        var entity = libraryService.findOne(id);
        var payload = BookDto.from(entity);

        return ResponseEntity.ok(payload);
    }

    @GetMapping("/filter")
    public ResponseEntity<BookDto> findByTitle(@RequestParam String title) {
        var entity = libraryService.findByTitle(title);
        var payload = BookDto.from(entity);
        return ResponseEntity.ok(payload);
    }
}
