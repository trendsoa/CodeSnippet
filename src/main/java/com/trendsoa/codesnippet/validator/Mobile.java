package com.trendsoa.codesnippet.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by jeszhang on 08-05-2017.
 */
@Documented
@Constraint(validatedBy = MobileValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface Mobile {
    String message() default "invalid mobile format"; //提示信息,可以写死,可以填写国际化的key

    //下面这两个属性必须添加
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
