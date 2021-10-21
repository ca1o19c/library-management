package com.academy.moviecrud.service;

import com.academy.moviecrud.domain.Movie;
import com.academy.moviecrud.http.dto.SearchResponseDto;
import com.academy.moviecrud.http.dto.MovieSearchQueryDto;
import com.academy.moviecrud.repository.MovieRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

@Service
public class MovieService {

    public static final String SORT_PROPERTY = "createdOn";
    public static final Class<Movie> ENTITY_CLASS = Movie.class;

    private final MovieRepository repository;
    private final MongoTemplate mongoTemplate;

    public MovieService(MovieRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    public SearchResponseDto<Movie> findAll(MovieSearchQueryDto queryDto) {
        queryDto.confirmIsValid();

        var query = this.buildQuery(queryDto);

        int page = queryDto.getPage();

        int total = Math.toIntExact(mongoTemplate.count(query, ENTITY_CLASS));

        int limit = queryDto.getPerPage();

        var totalPages = total > limit ? Math.floorDiv(total, limit) : 1;

        var direction = Sort.Direction.fromString(isEmpty(queryDto.getDir())
                ? "ASC"
                : queryDto.getDir());

        query.with(PageRequest.of(page, limit, Sort.by(direction, "createdAt")));

        var orders = mongoTemplate.find(query, ENTITY_CLASS);

        return new SearchResponseDto<>(total, totalPages, orders);
    }

    private int getTotalPages(int total, int limit) {
        return total > limit ? Math.floorDiv(total, limit) : 1;
    }

    private Query buildQuery(MovieSearchQueryDto queryDto) {
        Query query = new Query();
        var initialDate = this.toStartOfDay(queryDto.getInitialDate());
        var finalDate = this.toEndOfDay(queryDto.getFinalDate());

        if (!isNull(initialDate) && !isNull(finalDate)) {
            var criteria = Criteria.where(SORT_PROPERTY).gte(initialDate).lte(finalDate);
            query.addCriteria(criteria);
        }

        if (!isNull(initialDate) && isNull(finalDate)) {
            var criteria = Criteria.where(SORT_PROPERTY).gte(initialDate);
            query.addCriteria(criteria);
        }

        if (!isNull(finalDate) && isNull(initialDate)) {
            var criteria = Criteria.where(SORT_PROPERTY).lte(finalDate);
            query.addCriteria(criteria);
        }

        return query;
    }

    private Instant toStartOfDay(LocalDate localDate) {
        return localDate == null ? null : localDate
                .atStartOfDay(ZoneId.of("UTC"))
                .toInstant();
    }

    private Instant toEndOfDay(LocalDate localDate) {
        return localDate == null ? null : localDate.atTime(LocalTime.MAX)
                .atZone(ZoneId.of("UTC"))
                .toInstant();
    }
}
