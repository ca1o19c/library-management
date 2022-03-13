package com.academy.librarymanagement.adapters.in.dto;

import com.academy.librarymanagement.domain.BookAggregate;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public class BookResponse {

    public String image;
    private String id;
    private String title;
    private String publisher;
    private List<String> writers;
    @JsonProperty("updated_on")
    private LocalDateTime updatedOn;
    @JsonProperty("created_on")
    private LocalDateTime createdOn;

    public static BookResponse from(BookAggregate entity) {
        return BookResponse.builder()
                .withId(entity.getId())
                .withTitle(entity.getTitle())
                .withImage(entity.getImage())
                .withPublisher(entity.getPublisher())
                .withWriters(entity.getWriters())
                .withCreatedOn(entity.getCreatedOn())
                .withUpdatedOn(entity.getUpdatedOn())
                .build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        public String image;
        private String id;
        private String title;
        private String publisher;
        private List<String> writers;
        private LocalDateTime updatedOn;
        private LocalDateTime createdOn;

        public Builder withImage(String image) {
            this.image = image;
            return this;
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withPublisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public Builder withWriters(List<String> writers) {
            this.writers = writers;
            return this;
        }

        public Builder withUpdatedOn(LocalDateTime updatedOn) {
            this.updatedOn = updatedOn;
            return this;
        }

        public Builder withCreatedOn(LocalDateTime createdOn) {
            this.createdOn = createdOn;
            return this;
        }

        public BookResponse build() {
            BookResponse bookResponse = new BookResponse();
            bookResponse.publisher = this.publisher;
            bookResponse.createdOn = this.createdOn;
            bookResponse.id = this.id;
            bookResponse.image = this.image;
            bookResponse.title = this.title;
            bookResponse.updatedOn = this.updatedOn;
            bookResponse.writers = this.writers;
            return bookResponse;
        }
    }

    public String getImage() {
        return image;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public List<String> getWriters() {
        return writers;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }
}
