package com.trendsoa.codesnippet.validator;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by jeszhang on 09-05-2017.
 */
public class SpELClassValidator implements ConstraintValidator<SpELValidateClass, Object> {

    private ExpressionParser expressionParser = new SpelExpressionParser();
    private Expression parsedExpression;

    @Override
    public void initialize(SpELValidateClass spELValidateClass) {
        parsedExpression = expressionParser.parseExpression(spELValidateClass.value());
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        StandardEvaluationContext context = new StandardEvaluationContext(value);
        return (Boolean) parsedExpression.getValue(context);
    }
}
