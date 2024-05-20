package com.traini8.gftc.dtos;

import java.util.List;

import lombok.Data;

@Data
public class SearchFilter {
	private Integer studentCapacity;
	private String city;
	private String state;
	private String pincode;
	private List<String> courses;
}
