package dev.academy.movieapi.service;

import dev.academy.movieapi.domain.Movie;
import dev.academy.movieapi.exception.BadRequestException;
import dev.academy.movieapi.http.dto.MovieDto;
import dev.academy.movieapi.mapper.MovieMapper;
import dev.academy.movieapi.repository.MovieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository repository;

    public MovieService(final MovieRepository repository) {
        this.repository = repository;
    }

    public Page<Movie> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Movie> findByName(String name) {
        return repository.findByName(name);
    }

    @Transactional
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
