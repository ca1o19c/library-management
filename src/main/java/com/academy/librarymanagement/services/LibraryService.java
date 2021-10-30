package com.academy.librarymanagement.services;

import com.academy.librarymanagement.domain.Library;
import com.academy.librarymanagement.infra.data.LibraryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    public LibraryService(final LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public Page<Library> findAll(Pageable pageable) {
        return libraryRepository.findAll(pageable);
    }
}
