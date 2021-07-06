package com.school.utils.annotations;

import com.school.utils.validation.ValidateEnumParam;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidateEnumParam.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@NotNull
public @interface EnumValidator {

    String message();

    Class<? extends Enum<?>> enumType();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
