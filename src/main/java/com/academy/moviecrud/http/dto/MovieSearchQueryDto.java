package com.academy.moviecrud.http.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

public class MovieSearchQueryDto extends SearchQueryDto<MovieSearchQueryDto> {

    public MovieSearchQueryDto(@PositiveOrZero Integer page,
                               @Min(1) @Max(50) Integer perPage,
                               String direction, LocalDate initialDate, LocalDate finalDate) {
        super(page, perPage, direction, initialDate, finalDate);
    }

    public static MovieSearchQueryDto from(Integer page, Integer perPage, String direction,
                                           LocalDate initialDate, LocalDate finalDate) {
        return new MovieSearchQueryDto(page, perPage, direction, initialDate, finalDate);
    }
}
