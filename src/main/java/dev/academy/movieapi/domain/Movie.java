package dev.academy.movieapi.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Movie {

    private String id;
    private String name;
    private List<String> producers;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    public String getId() {
        return id;
    }

    public Movie setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Movie setName(String name) {
        this.name = name;
        return this;
    }

    public List<String> getProducers() {
        return Optional.ofNullable(producers)
                .map(Collections::unmodifiableList)
                .orElse(List.of());
    }

    public Movie setProducers(List<String> producers) {
        this.producers = producers;
        return this;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public Movie setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public Movie setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

    public void created(String id) {
        this.setId(id);
        this.setCreatedOn(LocalDateTime.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(name, movie.name) && Objects.equals(producers, movie.producers) && Objects.equals(createdOn, movie.createdOn) && Objects.equals(updatedOn, movie.updatedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, producers, createdOn, updatedOn);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", producers=" + producers +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
