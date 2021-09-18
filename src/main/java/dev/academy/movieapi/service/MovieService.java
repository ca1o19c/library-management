package dev.academy.movieapi.service;

import dev.academy.movieapi.domain.Movie;
import dev.academy.movieapi.dto.MovieDto;
import dev.academy.movieapi.exception.BadRequestException;
import dev.academy.movieapi.mapper.MovieMapper;
import dev.academy.movieapi.repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository repository;

    public MovieService(final MovieRepository repository) {
        this.repository = repository;
    }

    public List<Movie> findAll() {
        return repository.findAll();
    }

    public List<Movie> findByName(String name) {
        return repository.findByName(name);
    }

    public void createOne(MovieDto dto, String id) {
        var movie = MovieMapper.INSTANCE.toMovie(dto);

        movie.created(id, LocalDateTime.now());

        repository.save(movie);
    }

    public Movie findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new BadRequestException("ID not found"));
    }


    public void updateOne(String id, MovieDto dto) {
        var found = this.findById(id);

        var movie = MovieMapper.INSTANCE.toMovie(dto);

        movie
                .updated(LocalDateTime.now())
                .created(found.getId(), found.getCreatedOn());

        repository.save(movie);

    }

    public void deleteOne(String id) {
        var movie = this.findById(id);

        repository.deleteById(id);
    }
}
