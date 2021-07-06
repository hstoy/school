package com.school.utils.annotations;

import com.school.utils.validation.ValidateOptionalParam;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidateOptionalParam.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Optional {

    String message();

    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
}
