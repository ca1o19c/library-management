package com.academy.librarymanagement.infra.crosscutting.exception;

import static com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(SnakeCaseStrategy.class)
public class ErrorResponse {
    private final String message;
    private final int code;
    private final String status;
    private String objectName;
    private List<ErrorObject> errors;

    public ErrorResponse(String message, int code, String status, String objectName, List<ErrorObject> errors) {
        this.message = message;
        this.code = code;
        this.status = status;
        this.objectName = objectName;
        this.errors = errors;
    }

    public ErrorResponse(String message, int code, String status) {
        this.message = message;
        this.code = code;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getObjectName() {
        return objectName;
    }

    public List<ErrorObject> getErrors() {
        return errors;
    }
}
