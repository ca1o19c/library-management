package dev.academy.movieapi.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jdk.jfr.DataAmount;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Entity
public class Movie {
    @Id
    private String id;
    private String name;
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
        return Objects.equals(id, movie.id) && Objects.equals(name, movie.name) && Objects.equals(createdOn, movie.createdOn) && Objects.equals(updatedOn, movie.updatedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdOn, updatedOn);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
