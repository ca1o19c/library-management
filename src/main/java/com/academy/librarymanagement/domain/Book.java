package com.academy.librarymanagement.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Document(collection = "library-management")
public class Book {
    @Id
    private String id;

    public String title;

    public String publisher;

    public String image;

    public List<String> writers;

    private LocalDateTime updatedOn;

    private LocalDateTime createdOn;

    public String getId() {
        return id;
    }

    public Book setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public Book setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Book setImage(String image) {
        this.image = image;
        return this;
    }

    public List<String> getWriters() {
        return Optional.ofNullable(writers)
                .map(Collections::unmodifiableList)
                .orElse(List.of());
    }

    public Book setWriters(List<String> writers) {
        this.writers = writers;
        return this;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public Book setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public Book setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Book created() {
        this.createdOn = LocalDateTime.now();
        return this;
    }

    public Book update(Book book) {
        this.title = book.getTitle();
        this.publisher = book.getPublisher();
        this.image = book.getImage();
        this.writers = book.getWriters();
        this.updatedOn = LocalDateTime.now();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(publisher, book.publisher) && Objects.equals(image, book.image) && Objects.equals(writers, book.writers) && Objects.equals(updatedOn, book.updatedOn) && Objects.equals(createdOn, book.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, publisher, image, writers, updatedOn, createdOn);
    }

    @Override
    public String toString() {
        return "Library{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", image='" + image + '\'' +
                ", writers=" + writers +
                ", updatedOn=" + updatedOn +
                ", createdOn=" + createdOn +
                '}';
    }
}
