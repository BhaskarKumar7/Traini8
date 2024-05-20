package com.traini8.gftc.annotations.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.traini8.gftc.annotations.UniqueMobileNo;
import com.traini8.gftc.service.TrainingCenterService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class UniqueMobileNoValidator implements ConstraintValidator<UniqueMobileNo, String> {

	@Autowired
	private TrainingCenterService trainingCenterService;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return trainingCenterService.doesMobileNoExists(value) ? false :true;
	}

}
