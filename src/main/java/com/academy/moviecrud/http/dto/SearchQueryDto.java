package com.academy.moviecrud.http.dto;

import com.academy.moviecrud.domain.SelfValidator;
import com.academy.moviecrud.exception.BadRequestException;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

import static java.util.Objects.isNull;

@Valid
public abstract class SearchQueryDto<T> extends SelfValidator<T> {
    @PositiveOrZero
    protected final Integer page;

    @Min(1)
    @Max(50)
    protected final Integer perPage;

    @Valid
    protected final String dir;

    protected final LocalDate initialDate;

    protected final LocalDate finalDate;

    public SearchQueryDto(@PositiveOrZero Integer page,
                          @Min(1) @Max(50) Integer perPage,
                          @Valid String dir, LocalDate initialDate, LocalDate finalDate) {
        this.page = page;
        this.perPage = perPage;
        this.dir = dir;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public String getDir() {
        return dir;
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    @Override
    public void confirmIsValid() {
        super.confirmIsValid();

        if (!isNull(this.getInitialDate()) && !isNull(this.getFinalDate())) {
            if (this.getFinalDate().isBefore(this.getInitialDate())) {
                throw new BadRequestException("initial_date must be before final_date");
            }
        }
    }
}
