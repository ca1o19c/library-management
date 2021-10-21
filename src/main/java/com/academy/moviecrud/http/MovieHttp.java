package com.academy.moviecrud.http;

import com.academy.moviecrud.domain.Movie;
import com.academy.moviecrud.http.dto.PageDto;
import com.academy.moviecrud.http.dto.MovieSearchQueryDto;
import com.academy.moviecrud.service.MovieService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.util.stream.Collectors.toList;

@RestController
@Validated
@RequestMapping("/api/v1/movies")
public class MovieHttp {
    private final MovieService movieService;

    public MovieHttp(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<PageDto<MoviePayload>> findAll(
            @RequestParam(value = "page", defaultValue = "0", required = false) @PositiveOrZero Integer page,
            @RequestParam(value = "per_page", defaultValue = "50", required = false) Integer perPage,
            @RequestParam(value = "dir", required = false) String direction,
            @RequestParam(value = "initial_date", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate initialDate,
            @RequestParam(value = "final_date", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate finalDate) {

        var query = MovieSearchQueryDto.from(
                page, perPage, direction, initialDate, finalDate);

        var result = this.movieService.findAll(query);

        var ruleList = result.getResult()
                .stream()
                .map(MoviePayload::from)
                .collect(toList());

        var moviePageDto = new PageDto<>(
                query.getPage(),
                query.getPerPage(),
                result.getTotalPages(),
                result.getTotal(),
                ruleList
        );
        return ResponseEntity.ok(moviePageDto);
    }

    @PostMapping
    public ResponseEntity<?> createOne(@RequestBody @Valid MoviePayload moviePayload) {
        var id = this.createOneMovie(moviePayload.toEntity());
        var location = this.getLocation(id);
        return ResponseEntity.created(location).build();
    }

    public String createOneMovie(Movie movie) {
        movie.setCreatedOn(LocalDateTime.now());
        var createAtMongo = this.movieService.createOne(movie);
        return createAtMongo.getId();
    }

    private URI getLocation(String id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }
}
