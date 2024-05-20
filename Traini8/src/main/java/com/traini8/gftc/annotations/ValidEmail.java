package com.traini8.gftc.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.traini8.gftc.annotations.validators.ValidEmailValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = ValidEmailValidator.class)
public @interface ValidEmail {

	String message() default "Invalid Email";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
