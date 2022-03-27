package com.academy.librarymanagement.adapters.config.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({MethodArgumentNotValidException.class})
    protected ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        List<ErrorObject> errors = ex.getBindingResult().getFieldErrors().stream().map(error -> new ErrorObject(error.getDefaultMessage(), error.getField(), error.getRejectedValue())).collect(Collectors.toList());

        ErrorResponse errorResponse = new ErrorResponse("Request has invalid fields", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), ex.getBindingResult().getObjectName(), errors);

        log.error(ExceptionUtils.getStackTrace(ex));

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MissingServletRequestParameterException.class})
    protected ResponseEntity<Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {

        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name());

        log.error(ExceptionUtils.getStackTrace(ex));

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    protected ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {

        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name());

        log.error(ExceptionUtils.getStackTrace(ex));

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({BadRequestException.class})
    protected ResponseEntity<Object> handleBadRequestException(BadRequestException ex) {

        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name());

        log.error(ExceptionUtils.getStackTrace(ex));

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({BookNotFoundException.class})
    protected ResponseEntity<Object> handleConflictParkingSpot(BookNotFoundException ex) {

        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name());

        log.error(ExceptionUtils.getStackTrace(ex));

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
