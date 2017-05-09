package com.trendsoa.codesnippet.validator;

import java.lang.annotation.*;

/**
 * Created by jeszhang on 09-05-2017.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SpELValidateClasses {
    SpELValidateClass[] value();
}
