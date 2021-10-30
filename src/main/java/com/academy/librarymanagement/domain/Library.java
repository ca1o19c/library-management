package com.academy.librarymanagement.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Document(collection = "library-management")
public class Library {
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

    public Library setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Library setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public Library setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Library setImage(String image) {
        this.image = image;
        return this;
    }

    public List<String> getWriters() {
        return Optional.ofNullable(writers)
                .map(Collections::unmodifiableList)
                .orElse(List.of());
    }

    public Library setWriters(List<String> writers) {
        this.writers = writers;
        return this;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public Library setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public Library setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Library created() {
        this.createdOn = LocalDateTime.now();
        return this;
    }

    public Library updated(Library library) {
        this.title = library.getTitle();
        this.publisher = library.getPublisher();
        this.writers = library.getWriters();
        this.updatedOn = LocalDateTime.now();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(id, library.id) && Objects.equals(title, library.title) && Objects.equals(publisher, library.publisher) && Objects.equals(image, library.image) && Objects.equals(writers, library.writers) && Objects.equals(updatedOn, library.updatedOn) && Objects.equals(createdOn, library.createdOn);
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
