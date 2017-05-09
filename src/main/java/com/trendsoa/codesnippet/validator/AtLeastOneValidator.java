package com.trendsoa.codesnippet.validator;

import org.springframework.expression.spel.standard.SpelExpressionParser;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Created by jeszhang on 08-05-2017.
 */
public class AtLeastOneValidator implements ConstraintValidator<AtLeastOne, Object> {
    private static final SpelExpressionParser PARSER = new SpelExpressionParser();
    private String[] fields;

    @Override
    public void initialize(AtLeastOne atLeastOne) {
        fields = atLeastOne.value();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        return fields != null && fields.length > 0 ? Stream.of(fields).map(field -> PARSER.parseExpression(field).getValue(value)).anyMatch(Objects::nonNull) : true;
    }
}
