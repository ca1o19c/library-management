package dev.academy.movieapi.service;

import dev.academy.movieapi.domain.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private static List<Movie> movies;

    static {
        movies = new ArrayList<>(List.of());
    }

    public List<Movie> findAll() {
        return movies;
    }

    public void createOne(String id, Movie movie) {
        movie.created(id);
        movies.add(movie);
    }

    public Movie findById(String id) {
        return movies.stream()
                .filter(movie -> movie.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID not found"));
    }

    public void deleteOne(String id) {
        var movie = this.findById(id);
        movies.remove(movie);
    }
}
