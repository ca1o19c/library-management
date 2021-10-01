package dev.academy.movieapi.http;

import dev.academy.movieapi.domain.Movie;
import dev.academy.movieapi.mock.MovieMock;
import dev.academy.movieapi.service.MovieService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class MovieHttpTest {

    @InjectMocks
    private MovieHttp movieHttp;

    @Mock
    private MovieService movieService;

    @BeforeEach
    void setUp() {
        final var moviePage = new PageImpl<>(List.of(MovieMock.aMock()));
        BDDMockito.when(movieService.findAll(ArgumentMatchers.any()))
                .thenReturn(moviePage);
    }

    @Test
    @DisplayName("should find all movies when successful")
    void shouldFindAll() {
        final var name = MovieMock.aMock().getName();
        final var body = movieHttp.findAll(null).getBody();

        assertThat(body).isNotNull();
        assertThat(body.toList())
                .hasSize(1)
                .isNotEmpty();
        assertThat(body.toList().get(0).getName()).isEqualTo(name);
    }

    @Test
    void createOne() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
    }

    @Test
    void updateOne() {
    }

    @Test
    void deleteOne() {
    }
}