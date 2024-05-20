package com.traini8.gftc.annotations.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.traini8.gftc.annotations.UniqueEmail;
import com.traini8.gftc.service.TrainingCenterService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail,String> {

	@Autowired
	private TrainingCenterService trainingCenterService;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return trainingCenterService.doesEmailExists(value) ? false : true;
	}

}
