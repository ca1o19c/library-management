package dev.academy.movieapi.mapper;

import dev.academy.movieapi.domain.Movie;
import dev.academy.movieapi.http.dto.MovieDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class MovieMapper {
    public static final MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    public abstract Movie toMovie(MovieDto dto);
}
