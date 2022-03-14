package com.academy.librarymanagement.adapters.in;

import com.academy.librarymanagement.adapters.in.dto.BookRequest;
import com.academy.librarymanagement.adapters.in.dto.BookResponse;
import com.academy.librarymanagement.adapters.in.dto.BookSearchRequest;
import com.academy.librarymanagement.adapters.in.dto.PageResponse;
import com.academy.librarymanagement.application.LibraryActions;
import com.academy.librarymanagement.domain.Book;
import com.academy.librarymanagement.domain.FilteredBook;
import com.academy.librarymanagement.domain.SortType;
import com.academy.librarymanagement.ports.in.LibraryInbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/books")
public class LibraryController {

    @Autowired
    private LibraryInbound libraryInbound;

    @GetMapping
    public ResponseEntity<PageResponse<BookResponse>> findAll(@RequestParam(required = false) String title, @RequestParam(required = false) String publisher,
                                                              @RequestParam Integer page, @RequestParam Integer limit,
                                                              @RequestParam(value = "sort_type", defaultValue = "asc", required = false) String sortType,
                                                              @RequestParam(value = "initial_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate initialDate,
                                                              @RequestParam(value = "final_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate finalDate
    ) {

        BookSearchRequest search = BookSearchRequest.builder()
                .withTitle(title)
                .withPublisher(publisher)
                .withPage(page)
                .withLimit(limit)
                .withSortType(SortType.fromValue(sortType))
                .withInitialDate(initialDate)
                .withFinalDate(finalDate)
                .build();

        FilteredBook books = libraryInbound.findAll(search);

        List<BookResponse> bookResponseList = books.getBooks()
                .stream()
                .map(BookResponse::from)
                .collect(Collectors.toList());

        PageResponse<BookResponse> pageResponse = new PageResponse<>(
                bookResponseList, search.getPage(), search.getLimit(), books.getTotal()
        );

        return ResponseEntity.ok(pageResponse);
    }

    @PostMapping
    ResponseEntity<Void> create(@Valid @RequestBody BookRequest bookRequest) {
        Book book = BookRequest.from(bookRequest);

        libraryInbound.save(book);

        return ResponseEntity.created(LibraryActions.getLocation(book.getId())).build();
    }
}
