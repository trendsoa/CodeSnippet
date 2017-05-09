package com.trendsoa.codesnippet.validator;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * Created by jeszhang on 08-05-2017.
 */
public class MobileValidator implements ConstraintValidator<Mobile, String> {
    private static final Pattern pattern = Pattern.compile("^1(3|5|7|8|4)\\d{9}$");

    @Override
    public void initialize(Mobile mobile) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(value))
            return true;
        return pattern.matcher(value).matches();
    }
}
