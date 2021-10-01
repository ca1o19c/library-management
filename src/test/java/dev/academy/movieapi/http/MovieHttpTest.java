package dev.academy.movieapi.http;

import dev.academy.movieapi.domain.Movie;
import dev.academy.movieapi.mock.MovieMock;
import dev.academy.movieapi.service.MovieService;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runners.MethodSorters;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("Tests for movie http")
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

        BDDMockito.when(movieService.findById(ArgumentMatchers.eq("92b3c238-230d-11ec-9621-0242ac130002")))
                .thenReturn(MovieMock.aMock());

        BDDMockito.when(movieService.findByName(ArgumentMatchers.eq("Galaxy of guardians")))
                .thenReturn(List.of(MovieMock.aMock()));
    }

    @Test
    @DisplayName("should movies find all when successful")
    void shouldFindAll() {
        final var name = MovieMock.aMock().getName();
        final var body = movieHttp.findAll(null).getBody();

        assertThat(body).isNotNull();
        assertThat(body.toList())
                .hasSize(1)
                .isNotNull()
                .isNotEmpty();
        assertThat(body.toList().get(0).getName()).isEqualTo(name);
    }

    @Test
    void createOne() {
    }

    @Test
    @DisplayName("should movie find by id when successful")
    void shouldFindById() {
        final var id= MovieMock.aMock().getId();
        final var body = movieHttp.findById("92b3c238-230d-11ec-9621-0242ac130002").getBody();

        assertThat(body).isNotNull();
        assertThat(body.getId()).isEqualTo(id);
    }

    @Test
    @DisplayName("should not movie find by id when failure")
    void shouldNotFindById() {
        final var id= MovieMock.aMock().getId();
        final var body = movieHttp.findById("").getBody();

        assertThat(body).isNull();
    }

    @Test
    @DisplayName("should movie find by name when successful")
    void shouldFindByName() {
        final var name = MovieMock.aMock().getName();
        final var body = movieHttp.findByName("Galaxy of guardians").getBody();

        assertThat(body)
                .isNotNull()
                .isNotEmpty();
        assertThat(body.get(0).getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("should not movie find by name when failure")
    void shouldNotFindByName() {

        final var body = movieHttp.findByName("").getBody();

        assertThat(body)
                .isNotNull()
                .isEmpty();
    }

    @Test
    void updateOne() {
    }

    @Test
    void deleteOne() {
    }
}