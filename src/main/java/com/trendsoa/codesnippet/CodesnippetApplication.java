package com.trendsoa.codesnippet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@SpringBootApplication
public class CodesnippetApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodesnippetApplication.class, args);
	}

	// must have for method validation
	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		final MethodValidationPostProcessor methodValidationPostProcessor = new MethodValidationPostProcessor();
//        methodValidationPostProcessor.setValidator(validator());

		return methodValidationPostProcessor;
	}
}
