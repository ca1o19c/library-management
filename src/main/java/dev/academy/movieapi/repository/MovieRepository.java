package dev.academy.movieapi.repository;

import dev.academy.movieapi.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, String> {

    List<Movie> findByName(String name);
}
