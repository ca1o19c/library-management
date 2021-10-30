package com.academy.librarymanagement.infra.data;

import com.academy.librarymanagement.domain.Library;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends MongoRepository<Library, String> {
}
