package dev.academy.movieapi.dto;

import java.util.Objects;

public class MovieDto {

    private String name;

    public String getName() {
        return name;
    }

    public MovieDto setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDto movieDto = (MovieDto) o;
        return Objects.equals(name, movieDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "Name='" + name + '\'' +
                '}';
    }
}
