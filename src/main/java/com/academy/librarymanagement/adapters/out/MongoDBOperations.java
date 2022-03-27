package com.academy.librarymanagement.adapters.out;

import com.academy.librarymanagement.adapters.config.exception.BookNotFoundException;
import com.academy.librarymanagement.domain.Book;
import com.academy.librarymanagement.domain.BookSearch;
import com.academy.librarymanagement.domain.FilteredBook;
import com.academy.librarymanagement.domain.SortType;
import com.academy.librarymanagement.ports.out.MongoDBOperationsPortOutbound;
import com.academy.librarymanagement.ports.out.MongoDatabaseStorePortOutbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;

@Component
class MongoDBOperations implements MongoDBOperationsPortOutbound {

    private static final String CREATED_ON_PROPERTY = "createdOn";
    private static final String TITLE_PROPERTY = "title";
    private static final String PUBLISHER_PROPERTY = "publisher";
    private static final String ID_PROPERTY = "id";

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public ResearchedBook findAll(com.academy.librarymanagement.domain.BookSearch search) {
        Query query = this.buildQuery(search);

        int page = search.getPage();

        int limit = search.getLimit();

        Sort.Direction direction = Sort.Direction.fromString(isEmpty(search.getSortType()) ? SortType.ASC.getValue() : search.getSortType().getValue());

        int total = Math.toIntExact(mongoTemplate.count(query, com.academy.librarymanagement.adapters.out.Book.class));

        query.with(PageRequest.of(page, limit, Sort.by(direction, CREATED_ON_PROPERTY)));

        List<com.academy.librarymanagement.adapters.out.Book> books = mongoTemplate.find(query, com.academy.librarymanagement.adapters.out.Book.class);

        return new ResearchedBook(total, books);
    }

    @Override
    public void save(com.academy.librarymanagement.domain.Book book) {
        com.academy.librarymanagement.adapters.out.Book bookDocument = new com.academy.librarymanagement.adapters.out.Book();

        bookDocument.setId(book.getId());
        bookDocument.setTitle(book.getTitle());
        bookDocument.setImage(book.getImage());
        bookDocument.setPublisher(book.getPublisher());
        bookDocument.setWriters(book.getWriters());
        bookDocument.created();

        mongoTemplate.save(bookDocument);
    }

    @Override
    public Optional<com.academy.librarymanagement.adapters.out.Book> findOne(String id) {
        Query query = new Query();

        query.addCriteria(Criteria.where(ID_PROPERTY).is(id));

        return Optional.ofNullable(mongoTemplate.findOne(query, com.academy.librarymanagement.adapters.out.Book.class));
    }

    @Override
    public Optional<com.academy.librarymanagement.adapters.out.Book> deleteOne(String id) {
        Query query = new Query();

        query.addCriteria(Criteria.where(ID_PROPERTY).is(id));

        return Optional.ofNullable(mongoTemplate.findAndRemove(query, com.academy.librarymanagement.adapters.out.Book.class));
    }

    private Query buildQuery(com.academy.librarymanagement.domain.BookSearch search) {
        Query query = new Query();

        Instant initialDate = toStartOfDay(search.getInitialDate());
        Instant finalDate = toEndOfDay(search.getFinalDate());

        if (!isNull(initialDate) && !isNull(finalDate))
            query.addCriteria(Criteria.where(CREATED_ON_PROPERTY).gte(initialDate).lte(finalDate));

        if (!isNull(initialDate) && isNull(finalDate))
            query.addCriteria(Criteria.where(CREATED_ON_PROPERTY).gte(initialDate));

        if (!isNull(finalDate) && isNull(initialDate))
            query.addCriteria(Criteria.where(CREATED_ON_PROPERTY).lte(finalDate));

        String title = search.getTitle();

        if (!isNull(title)) query.addCriteria(Criteria.where(TITLE_PROPERTY).is(title));

        String publisher = search.getPublisher();

        if (!isNull(publisher)) query.addCriteria(Criteria.where(PUBLISHER_PROPERTY).is(publisher));

        return query;
    }

    private Instant toStartOfDay(LocalDate localDate) {
        return localDate == null ? null : localDate.atStartOfDay(ZoneId.of("UTC")).toInstant();
    }

    private Instant toEndOfDay(LocalDate localDate) {
        return localDate == null ? null : localDate.atTime(LocalTime.MAX).atZone(ZoneId.of("UTC")).toInstant();
    }
}
