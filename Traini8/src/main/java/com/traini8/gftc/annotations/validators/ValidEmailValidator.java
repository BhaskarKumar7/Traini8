package com.traini8.gftc.annotations.validators;

import org.springframework.util.StringUtils;

import com.traini8.gftc.annotations.ValidEmail;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidEmailValidator implements ConstraintValidator<ValidEmail, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(StringUtils.hasText(value)) {
			return value.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
		}
		else {
			return true;
		}
	}

}
