package com.academy.moviecrud.http;

import com.academy.moviecrud.http.dto.PageDto;
import com.academy.moviecrud.http.dto.MovieSearchQueryDto;
import com.academy.moviecrud.service.MovieService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

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
            @RequestParam(value = "dir", defaultValue = "ASC", required = false) String direction,
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
}
