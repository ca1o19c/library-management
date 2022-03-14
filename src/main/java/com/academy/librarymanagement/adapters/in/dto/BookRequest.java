package com.academy.librarymanagement.adapters.in.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BookRequest {
    @NotBlank(message = "The image url cannot be blank")
    public String image;

    @NotBlank(message = "The title cannot be blank")
    private String title;
    @NotBlank(message = "The publisher name cannot be blank")
    private String publisher;

    @NotEmpty(message = "The writers name cannot be empty")
    private List<@NotBlank(message = "Field cannot be blank") String> writers;

    public static com.academy.librarymanagement.domain.Book from(BookRequest dto) {
        return com.academy.librarymanagement.domain.Book.builder()
                .withId(UUID.randomUUID().toString())
                .withTitle(dto.getTitle())
                .withImage(dto.getImage())
                .withPublisher(dto.getPublisher())
                .withWriters(dto.getWriters())
                .build();
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getPublisher() {
        return publisher;
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
}
