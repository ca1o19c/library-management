package com.academy.librarymanagement.adapters.out;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Document(collection = "library")
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

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
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
        return "Library{" + "id='" + id + '\'' + ", title='" + title + '\'' + ", publisher='" + publisher + '\'' + ", image='" + image + '\'' + ", writers=" + writers + ", updatedOn=" + updatedOn + ", createdOn=" + createdOn + '}';
    }
}
