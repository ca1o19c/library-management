package com.academy.moviecrud.domain;

import javax.validation.*;
import java.util.Set;

public abstract class SelfValidator<T> {
    private final Validator validator;

    public SelfValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public void confirmIsValid() throws ConstraintViolationException {
        Set<ConstraintViolation<T>> violations = validator.validate((T) this);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
