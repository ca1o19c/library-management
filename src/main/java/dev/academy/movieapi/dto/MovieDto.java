package dev.academy.movieapi.dto;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class MovieDto {

    @NotBlank
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
}
