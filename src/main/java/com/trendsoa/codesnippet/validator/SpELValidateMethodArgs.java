package com.trendsoa.codesnippet.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by jeszhang on 09-05-2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Documented
@Constraint(validatedBy = SpELMethodArgsValidator.class)
public @interface SpELValidateMethodArgs {
    String message() default "{spel.method.args.validation.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value();
}
