package com.trendsoa.codesnippet.validator;

import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jeszhang on 09-05-2017.
 */
@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class SpELMethodArgsValidator implements ConstraintValidator<SpELValidateMethodArgs, Object[]> {

    private ExpressionParser parser = new SpelExpressionParser();
    private Expression parsedExpression;

    @Override
    public void initialize(SpELValidateMethodArgs spELValidateMethodArgs) {
        parsedExpression = parser.parseExpression(spELValidateMethodArgs.value());
    }

    @Override
    public boolean isValid(Object[] arguments, ConstraintValidatorContext context) {

        List<String> parameterNames = ((ConstraintValidatorContextImpl) context).getMethodParameterNames();

        Map<String, Object> bindings = getBindings(arguments, parameterNames);

        StandardEvaluationContext evaluationContext = new StandardEvaluationContext();
        evaluationContext.setVariables(bindings);

        Boolean result = this.parsedExpression.getValue(evaluationContext, Boolean.class);
        return result == null ? true : result.booleanValue();
    }

    private Map<String, Object> getBindings(Object[] arguments, List<String> parameterNames) {
        Map<String, Object> bindings = new HashMap();

        for (int i = 0; i < arguments.length; i++) {
            bindings.put(parameterNames.get(i), arguments[i]);
        }

        return bindings;
    }
}
