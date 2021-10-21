package com.academy.moviecrud.http;

import com.academy.moviecrud.domain.Movie;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;

@JsonNaming(SnakeCaseStrategy.class)
public class MoviePayload {

    private String id;

    private String title;

    private Double imdbRating;

    @NotEmpty
    private List<@NotBlank String> directors;

    private LocalDateTime updatedOn;

    private LocalDateTime createdOn;

    public static MoviePayload from(Movie entity) {
        return new MoviePayload()
                .setId(entity.getId())
                .setTitle(entity.getTitle())
                .setImdbRating(entity.getImdbRating())
                .setDirectors(entity.getDirectors())
                .setCreatedOn(entity.getCreatedOn())
                .setUpdatedOn(entity.getUpdatedOn());
    }

    public String getId() {
        return id;
    }

    public MoviePayload setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MoviePayload setTitle(String title) {
        this.title = title;
        return this;
    }

    public Double getImdbRating() {
        return imdbRating;
    }

    public MoviePayload setImdbRating(Double imdbRating) {
        this.imdbRating = imdbRating;
        return this;
    }

    public List<String> getDirectors() {
        return Optional.ofNullable(directors)
                .map(Collections::unmodifiableList)
                .orElse(List.of());
    }

    public MoviePayload setDirectors(List<String> directors) {
        this.directors = directors;
        return this;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public MoviePayload setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public MoviePayload setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Movie toEntity() {
        return new Movie()
                .setTitle(title)
                .setDirectors(directors)
                .setImdbRating(imdbRating);
    }
}
