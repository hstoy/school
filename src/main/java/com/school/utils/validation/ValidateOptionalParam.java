package com.school.utils.validation;

import com.school.utils.annotations.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidateOptionalParam implements ConstraintValidator<Optional, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value.isEmpty()) {
            return true;
        }

        return value.matches("[a-zA-Z]{1,50}");
    }
}
