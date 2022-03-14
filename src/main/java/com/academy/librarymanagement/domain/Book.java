package com.academy.librarymanagement.domain;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Book {

    private String id;
    private String title;
    private String publisher;
    private String image;
    private List<String> writers;
    private LocalDateTime updatedOn;
    private LocalDateTime createdOn;

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String title;
        private String publisher;
        private String image;
        private List<String> writers;
        private String id;
        private LocalDateTime updatedOn;
        private LocalDateTime createdOn;

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

        public Builder withImage(String image) {
            this.image = image;
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

        public Book build() {
            Book book = new Book();
            book.id = this.id;
            book.updatedOn = this.updatedOn;
            book.title = this.title;
            book.image = this.image;
            book.publisher = this.publisher;
            book.writers = this.writers;
            book.createdOn = this.createdOn;
            return book;
        }
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

    public String getImage() {
        return image;
    }

    public List<String> getWriters() {
        return Optional.ofNullable(writers)
                .map(Collections::unmodifiableList)
                .orElse(List.of());
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void createdOn(Book book) {
        this.title = book.getTitle();
        this.publisher = book.getPublisher();
        this.image = book.getImage();
        this.writers = book.getWriters();
        this.updatedOn = LocalDateTime.now();
    }

    public void updatedOn() {
        this.createdOn = LocalDateTime.now();
    }
}


