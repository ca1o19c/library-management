package dev.academy.movieapi.http;

import dev.academy.movieapi.domain.Movie;
import dev.academy.movieapi.dto.MovieDto;
import dev.academy.movieapi.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@Validated
@RequestMapping("/v1/movies")
public class MovieHttp {

    private final MovieService movieService;

    public MovieHttp(final MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> findAll() {
        return new ResponseEntity<>(movieService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie> createOne(@RequestBody @Validated MovieDto dto) {
        var id = UUID.randomUUID().toString();

        movieService.createOne(dto, id);

        var location = this.getLocation(id);
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findById(@PathVariable String id) {
        return new ResponseEntity<>(movieService.findById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Movie>> findByName(@RequestParam(required = false) String name) {
        return new ResponseEntity<>(movieService.findByName(name), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> updateOne(@PathVariable String id, @RequestBody MovieDto dto) {
        movieService.updateOne(id, dto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOne(@PathVariable String id) {
        movieService.deleteOne(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private URI getLocation(String id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }
}
