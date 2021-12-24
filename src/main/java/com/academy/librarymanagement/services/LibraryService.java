package com.academy.librarymanagement.services;

import com.academy.librarymanagement.domain.Book;
import com.academy.librarymanagement.infra.crosscutting.exception.BookNotFoundException;
import com.academy.librarymanagement.infra.data.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    public LibraryService(final LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<Book> findAll() {
        return libraryRepository.findAll();
    }

    public Book createOne(Book book) {
        return this.libraryRepository.save(book.created());
    }

    public Book findOne(String id) {
        return this.libraryRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    public Book findByTitle(String title) {
        return this.libraryRepository.findByTitle(title).orElseThrow(BookNotFoundException::new);
    }
}
