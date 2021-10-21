package com.academy.moviecrud.exception;

public class ErrorDetailDTO {

    private String item;
    private String description;

    public ErrorDetailDTO() {
    }

    public ErrorDetailDTO(String item, String description) {
        this.item = item;
        this.description = description;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
