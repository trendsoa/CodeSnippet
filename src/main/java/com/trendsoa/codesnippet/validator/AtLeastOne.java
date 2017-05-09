package com.trendsoa.codesnippet.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by jeszhang on 08-05-2017.
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AtLeastOneValidator.class)
public @interface AtLeastOne {
    String[] value();

    String message() default "{AtLeastOne.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
