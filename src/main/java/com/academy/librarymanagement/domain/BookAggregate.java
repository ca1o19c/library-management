package com.academy.librarymanagement.domain;

import java.time.LocalDateTime;
import java.util.List;

public class BookAggregate {

    private String id;
    public String title;
    public String publisher;
    public String image;
    public List<String> writers;
    private LocalDateTime updatedOn;
    private LocalDateTime createdOn;

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        public String title;
        public String publisher;
        public String image;
        public List<String> writers;
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

        public BookAggregate build() {
            BookAggregate bookAggregate = new BookAggregate();
            bookAggregate.id = this.id;
            bookAggregate.updatedOn = this.updatedOn;
            bookAggregate.title = this.title;
            bookAggregate.image = this.image;
            bookAggregate.publisher = this.publisher;
            bookAggregate.writers = this.writers;
            bookAggregate.createdOn = this.createdOn;
            return bookAggregate;
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
        return writers;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void createdOn(BookAggregate bookAggregate) {
        this.title = bookAggregate.getTitle();
        this.publisher = bookAggregate.getPublisher();
        this.image = bookAggregate.getImage();
        this.writers = bookAggregate.getWriters();
        this.updatedOn = LocalDateTime.now();
    }

    public void updatedOn() {
        this.createdOn = LocalDateTime.now();
    }
}


