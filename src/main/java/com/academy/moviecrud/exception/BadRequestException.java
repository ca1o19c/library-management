package com.academy.moviecrud.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class BadRequestException extends RuntimeException{
    private static final long serialVersionUID = -1L;

    private List<ErrorDetailDto> details;

    public BadRequestException(String message, String messageTemplate, String... values) {
        super(message);

        String resultMessageTemplate = null;

        try {
            details = new ArrayList<ErrorDetailDto>();
        } catch (Exception e) {
            if (values != null && values.length > 0)
                resultMessageTemplate = values[0];
        } finally {
            details.add(new ErrorDetailDto(message, resultMessageTemplate));
        }

    }

    public BadRequestException(String message, ErrorDetailDto... details) {
        super(message);
        if (details != null)
            this.details = Arrays.asList(details);
    }

    public BadRequestException(List<ErrorDetailDto> details) {
        super("Bad Request");
        this.details = details;
    }

    public BadRequestException(Set<ErrorDetailDto> details) {
        super("Bad Request");
        this.details = new ArrayList<ErrorDetailDto>(details);
    }

    public List<ErrorDetailDto> getDetails() {
        return details;
    }
}
