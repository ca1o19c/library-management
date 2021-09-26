package dev.academy.movieapi.repository;

import dev.academy.movieapi.domain.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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

    private Movie createMovie() {
        return new Movie()
                .setId(UUID.randomUUID().toString())
                .setName("Spider Man")
                .setCreatedOn(LocalDateTime.now());
    }
}