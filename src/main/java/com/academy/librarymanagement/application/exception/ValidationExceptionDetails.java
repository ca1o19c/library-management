package com.academy.librarymanagement.application.exception;

import java.time.LocalDateTime;

public class ValidationExceptionDetails extends ExceptionDetails {
    private final String fields;
    private final String fieldsMessage;

    public ValidationExceptionDetails(String fields, String fieldsMessage) {
        this.fields = fields;
        this.fieldsMessage = fieldsMessage;
    }

    public String getFields() {
        return fields;
    }

    public String getFieldsMessage() {
        return fieldsMessage;
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public ExceptionDetails setTitle(String title) {
        return super.setTitle(title);
    }

    @Override
    public int getStatus() {
        return super.getStatus();
    }

    @Override
    public ExceptionDetails setStatus(int status) {
        return super.setStatus(status);
    }

    @Override
    public String getDetails() {
        return super.getDetails();
    }

    @Override
    public ExceptionDetails setDetails(String details) {
        return super.setDetails(details);
    }

    @Override
    public String getDeveloperMessage() {
        return super.getDeveloperMessage();
    }

    @Override
    public ExceptionDetails setDeveloperMessage(String developerMessage) {
        return super.setDeveloperMessage(developerMessage);
    }

    @Override
    public LocalDateTime getTimestamp() {
        return super.getTimestamp();
    }

    @Override
    public ExceptionDetails setTimestamp(LocalDateTime timestamp) {
        return super.setTimestamp(timestamp);
    }
}
