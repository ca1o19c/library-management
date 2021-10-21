package com.academy.moviecrud.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Document(collation = "movie-crud-movies")
public class Movie {
    @Id
    private String id;

    private String title;

    private Double imdbRating;

    private List<String> directors;

    private LocalDateTime updatedOn;

    private LocalDateTime createdOn;

    public String getId() {
        return id;
    }

    public Movie setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Movie setTitle(String title) {
        this.title = title;
        return this;
    }

    public Double getImdbRating() {
        return imdbRating;
    }

    public Movie setImdbRating(Double imdbRating) {
        this.imdbRating = imdbRating;
        return this;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public Movie setDirectors(List<String> directors) {
        this.directors = directors;
        return this;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public Movie setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public Movie setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Movie created() {
        this.createdOn = LocalDateTime.now();
        return this;
    }

    public Movie update(Movie movie) {
        this.title = movie.getTitle();
        this.imdbRating = movie.getImdbRating();
        this.directors = movie.getDirectors();
        this.updatedOn = LocalDateTime.now();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(title, movie.title) && Objects.equals(imdbRating, movie.imdbRating) && Objects.equals(directors, movie.directors) && Objects.equals(updatedOn, movie.updatedOn) && Objects.equals(createdOn, movie.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, imdbRating, directors, updatedOn, createdOn);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", imdbRating=" + imdbRating +
                ", directors=" + directors +
                ", updatedOn=" + updatedOn +
                ", createdOn=" + createdOn +
                '}';
    }
}
