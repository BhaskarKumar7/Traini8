package com.traini8.gftc.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.traini8.gftc.annotations.validators.UniqueMobileNoValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = UniqueMobileNoValidator.class)
public @interface UniqueMobileNo {
	String message() default "Mobile number already exists";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
