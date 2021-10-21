package com.academy.moviecrud.repository;

import com.academy.moviecrud.domain.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {

}
