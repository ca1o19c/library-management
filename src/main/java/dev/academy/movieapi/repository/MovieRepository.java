package dev.academy.movieapi.repository;

import dev.academy.movieapi.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, String> {

}
