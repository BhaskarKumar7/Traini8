package com.traini8.gftc.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.traini8.gftc.annotations.UniqueEmail;
import com.traini8.gftc.annotations.UniqueMobileNo;
import com.traini8.gftc.annotations.ValidEmail;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TrainingCenterDto {
	private Long trainingCenterId;
	@NotBlank
	@Size(max = 40,message = "Training center name should be less than 40 characters")
	@Pattern(regexp = "[a-z A-Z]+",message = "Training center name should be a text")
	private String trainingCenterName;
	@NotBlank
	@Size(min = 12,max = 12,message = "Center code should be exactly 12 characters")
	@Pattern(regexp = "^[a-zA-Z0-9]+$",message = "Training center code should be alphanumeric")
	private String trainingCenterCode;
	@Valid
	private AddressDto address;
	@Pattern(regexp = "^[0-9]+$", message = "student capacity should be a number")
	private String studentCapacity;
	private List<String> coursesOffered;
	private LocalDateTime createdOn;
	@ValidEmail // checks for valid email coming from the payload
	@UniqueEmail //checks for email existence in the db
	private String contactEmail;
	@NotBlank(message = "Contact phone should not be empty")
	@Pattern(regexp = "^[0-9]{10}$",message = "Contact phone should be a 10 digit number")
	@UniqueMobileNo //checks for mobile no existence in the db
	private String contactPhone;
}
