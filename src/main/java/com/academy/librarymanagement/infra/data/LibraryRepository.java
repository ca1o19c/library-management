package com.academy.librarymanagement.infra.data;

import com.academy.librarymanagement.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibraryRepository extends MongoRepository<Book, String> {
    Optional<Book> findByTitle(String title);
}
