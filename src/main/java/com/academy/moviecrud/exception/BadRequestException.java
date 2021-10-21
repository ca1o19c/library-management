package com.academy.moviecrud.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class BadRequestException extends RuntimeException{
    private static final long serialVersionUID = -1L;

    private List<ErrorDetailDTO> details;

    public BadRequestException(String message, String messageTemplate, String... values) {
        super(message);

        String resultMessageTemplate = null;

        try {
            details = new ArrayList<ErrorDetailDTO>();
        } catch (Exception e) {
            if (values != null && values.length > 0)
                resultMessageTemplate = values[0];
        } finally {
            details.add(new ErrorDetailDTO(message, resultMessageTemplate));
        }

    }

    public BadRequestException(String message, ErrorDetailDTO... details) {
        super(message);
        if (details != null)
            this.details = Arrays.asList(details);
    }

    public BadRequestException(List<ErrorDetailDTO> details) {
        super("Bad Request");
        this.details = details;
    }

    public BadRequestException(Set<ErrorDetailDTO> details) {
        super("Bad Request");
        this.details = new ArrayList<ErrorDetailDTO>(details);
    }

    public List<ErrorDetailDTO> getDetails() {
        return details;
    }
}
