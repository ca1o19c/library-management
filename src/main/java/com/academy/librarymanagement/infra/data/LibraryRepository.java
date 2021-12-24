package com.academy.librarymanagement.infra.data;

import com.academy.librarymanagement.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends MongoRepository<Book, String> {
    List<Book> findByTitle(String title);
}
