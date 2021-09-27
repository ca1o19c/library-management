package dev.academy.movieapi.mock;

import dev.academy.movieapi.domain.Movie;

import java.time.LocalDateTime;
import java.util.UUID;

public class MovieMock {
    public static Movie aMock() {
        return new Movie()
                .setId(UUID.randomUUID().toString())
                .setName("Galaxy of guardians")
                .setCreatedOn(LocalDateTime.now());
    }
}
