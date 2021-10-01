package dev.academy.movieapi.mock;

import dev.academy.movieapi.http.dto.MovieDto;

public class MovieDtoMock {
    public static MovieDto aMock() {
        return new MovieDto()
                .setName("Galaxy of guardians");
    }
}
