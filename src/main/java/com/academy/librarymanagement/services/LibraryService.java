package com.academy.librarymanagement.services;

import com.academy.librarymanagement.domain.Book;
import com.academy.librarymanagement.infra.crosscutting.exception.BookNotFoundException;
import com.academy.librarymanagement.infra.data.LibraryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    public LibraryService(final LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public Page<Book> findAll(Pageable pageable) {
        return libraryRepository.findAll(pageable);
    }

    public Book createOne(Book book) {
        return this.libraryRepository.save(book.created());
    }

    public Book findOne(String id) {
        return this.libraryRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }
}
