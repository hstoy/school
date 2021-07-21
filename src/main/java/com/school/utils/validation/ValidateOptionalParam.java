package com.school.utils.validation;

import com.school.utils.annotations.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidateOptionalParam implements ConstraintValidator<Optional, String> {
    private String regex;

    @Override
    public void initialize(Optional constraintAnnotation) {
        regex = constraintAnnotation.regex();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return value.matches(regex);
    }
}
