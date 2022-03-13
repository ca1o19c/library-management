package com.academy.librarymanagement.adapters.config.exception;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Date;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class NotFoundExceptionResponse {
    private Date timeStamp;
    private Integer status;
    private String message;

    public NotFoundExceptionResponse(Date timeStamp, Integer status, String message) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.message = message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public NotFoundExceptionResponse setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public NotFoundExceptionResponse setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public NotFoundExceptionResponse setMessage(String message) {
        this.message = message;
        return this;
    }
}
