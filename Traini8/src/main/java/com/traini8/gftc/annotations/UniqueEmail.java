package com.traini8.gftc.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.traini8.gftc.annotations.validators.UniqueEmailValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = UniqueEmailValidator.class)
public @interface UniqueEmail {
	String message() default "Email already exists";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
