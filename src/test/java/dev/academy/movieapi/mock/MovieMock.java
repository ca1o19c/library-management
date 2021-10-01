package dev.academy.movieapi.mock;

import dev.academy.movieapi.domain.Movie;

import java.time.LocalDateTime;
import java.util.UUID;

public class MovieMock {
    public static Movie aMock() {
        return new Movie()
                .setId("92b3c238-230d-11ec-9621-0242ac130002")
                .setName("Galaxy of guardians")
                .setCreatedOn(LocalDateTime.now());
    }
}
