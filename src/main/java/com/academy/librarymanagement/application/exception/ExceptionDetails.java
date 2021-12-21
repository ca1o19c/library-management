package com.academy.librarymanagement.application.exception;

import java.time.LocalDateTime;

public class ExceptionDetails {
    protected String title;
    protected int status;
    protected String details;
    protected String developerMessage;
    protected LocalDateTime timestamp;

    public String getTitle() {
        return title;
    }

    public ExceptionDetails setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public ExceptionDetails setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public ExceptionDetails setDetails(String details) {
        this.details = details;
        return this;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public ExceptionDetails setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
        return this;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public ExceptionDetails setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}
