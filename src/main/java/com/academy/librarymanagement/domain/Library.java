package com.academy.librarymanagement.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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
