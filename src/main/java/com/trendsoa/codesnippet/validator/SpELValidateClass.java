package com.trendsoa.codesnippet.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * validate class by spring EL
 * Created by jeszhang on 09-05-2017.
 */
@Documented
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SpELClassValidator.class)
@Repeatable(SpELValidateClasses.class) //only support by jdk8
public @interface SpELValidateClass {

    String message() default "{spel.class.validation.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value();
}
