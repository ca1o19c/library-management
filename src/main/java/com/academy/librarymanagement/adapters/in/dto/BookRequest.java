package com.academy.librarymanagement.adapters.in.dto;

import com.academy.librarymanagement.adapters.out.Book;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BookRequest {
    @NotBlank(message = "The image url cannot be blank")
    public String image;
    private String id;
    @NotBlank(message = "The title cannot be blank")
    private String title;
    @NotBlank(message = "The publisher name cannot be blank")
    private String publisher;

    @NotEmpty(message = "The writers name cannot be empty")
    private List<@NotBlank(message = "Field cannot be blank") String> writers;

    private LocalDateTime updatedOn;

    private LocalDateTime createdOn;

    public static BookRequest from(Book entity) {
        return new BookRequest()
                .setId(entity.getId())
                .setTitle(entity.getTitle())
                .setImage(entity.getImage())
                .setPublisher(entity.getPublisher())
                .setWriters(entity.getWriters())
                .setCreatedOn(entity.getCreatedOn())
                .setUpdatedOn(entity.getUpdatedOn());
    }

    public String getId() {
        return id;
    }

    public BookRequest setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BookRequest setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImage() {
        return image;
    }

    public BookRequest setImage(String image) {
        this.image = image;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public BookRequest setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public List<String> getWriters() {
        return Optional.ofNullable(writers)
                .map(Collections::unmodifiableList)
                .orElse(List.of());
    }

    public BookRequest setWriters(List<String> writers) {
        this.writers = writers;
        return this;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public BookRequest setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public BookRequest setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }
}
