package dev.academy.movieapi.repository;

import dev.academy.movieapi.domain.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayName("Tests for movie repository")
class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @DisplayName("should create movie when successful")
    @Test
    void shouldCreateOne() {
        var movieToBeSaved = createMovie();
        var movieSaved = this.movieRepository.save(movieToBeSaved);

        assertThat(movieSaved).isNotNull();
        assertThat(movieSaved.getId()).isNotNull();
        assertThat(movieSaved.getName()).isEqualTo(movieToBeSaved.getName());
        assertThat(movieSaved.getCreatedOn()).isEqualTo(movieToBeSaved.getCreatedOn());
    }

    @DisplayName("should update movie when successful")
    @Test
    void shouldUpdateOne() {
        var movieToBeSaved = createMovie();
        var movieSaved = this.movieRepository.save(movieToBeSaved);

        movieSaved.setName("Doctor Strange");
        movieSaved.setUpdatedOn(LocalDateTime.now());

        var movieUpdated = this.movieRepository.save(movieSaved);

        assertThat(movieUpdated).isNotNull();
        assertThat(movieUpdated.getId()).isNotNull();
        assertThat(movieUpdated.getName()).isEqualTo(movieSaved.getName());
        assertThat(movieUpdated.getCreatedOn()).isEqualTo(movieSaved.getCreatedOn());
        assertThat(movieUpdated.getUpdatedOn()).isEqualTo(movieSaved.getUpdatedOn());
    }

    private Movie createMovie() {
        return new Movie()
                .setId(UUID.randomUUID().toString())
                .setName("Spider Man")
                .setCreatedOn(LocalDateTime.now());
    }
}