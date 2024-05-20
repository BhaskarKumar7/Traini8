package com.traini8.gftc.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AddressDto {
	
	private Long addressId;
	@NotBlank(message = "detailedAddress should not be empty")
	private String detailedAddress;
	@NotBlank(message = "city should not be empty")
	@Pattern(regexp = "[a-z A-Z /s]+",message = "City name should be text")
	private String city;
	@NotBlank(message = "state should not be empty")
	@Pattern(regexp = "[a-z A-Z /s]+",message = "State name should be text")
	private String state;
	@NotBlank(message = "pincode should not be empty")
	@Pattern(regexp = "^[0-9]+$")
	private String pincode; 
}
