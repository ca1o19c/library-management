package com.academy.librarymanagement.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class LibraryDto {
    private String id;

    @NotBlank
    private String title;

    @NotBlank
    public String image;

    @NotBlank
    private String publisher;

    @NotEmpty
    private List<@NotBlank String> writers;

    private LocalDateTime updatedOn;

    private LocalDateTime createdOn;

    public static LibraryDto from(Library entity) {
        return new LibraryDto()
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

    public LibraryDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public LibraryDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImage() {
        return image;
    }

    public LibraryDto setImage(String image) {
        this.image = image;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public LibraryDto setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public List<String> getWriters() {
        return Optional.ofNullable(writers)
                .map(Collections::unmodifiableList)
                .orElse(List.of());
    }

    public LibraryDto setWriters(List<String> writers) {
        this.writers = writers;
        return this;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public LibraryDto setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LibraryDto setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Library toEntity() {
        return new Library()
                .setTitle(title)
                .setImage(image)
                .setPublisher(publisher)
                .setWriters(writers);
    }
}
