package com.school.utils.validation;

import com.school.utils.annotations.EnumValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidateEnumParam implements ConstraintValidator<EnumValidator, String> {

    Set<String> values;

    @Override
    public void initialize(EnumValidator constraintAnnotation) {
        values = new HashSet<>();
        Class<? extends Enum<?>> enumClass = constraintAnnotation.enumType();

        Enum[] enumValArr = enumClass.getEnumConstants();

        for (Enum enumVal : enumValArr) {
            values.add(enumVal.toString().toUpperCase());
        }
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.contains(value.toUpperCase());
    }
}
