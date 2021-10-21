package com.academy.moviecrud.http.dto;

import com.academy.moviecrud.domain.SortType;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

public class MovieSearchQueryDto extends SearchQueryDto<MovieSearchQueryDto> {

    public MovieSearchQueryDto(@PositiveOrZero Integer page,
                              @Min(1) @Max(50) Integer perPage,
                              @Valid SortType dir, LocalDate initialDate, LocalDate finalDate) {
        super(page, perPage, dir, initialDate, finalDate);
    }

    public static MovieSearchQueryDto from(Integer page, Integer perPage, SortType direction,
                                          LocalDate initialDate, LocalDate finalDate) {
        return new MovieSearchQueryDto(page, perPage, direction, initialDate, finalDate);
    }
}
