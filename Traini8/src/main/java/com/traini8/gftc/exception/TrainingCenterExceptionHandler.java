package com.traini8.gftc.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TrainingCenterExceptionHandler {

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException mae){
		List<String> errorsList = new ArrayList<>();
		mae.getFieldErrors().forEach(fieldError -> 
			errorsList.add(fieldError.getDefaultMessage())
		);
		Map<String,List<String>> respMap = new HashMap<>();
		respMap.put("errorsList", errorsList);
		return new ResponseEntity<>(respMap,HttpStatus.BAD_REQUEST);
	}
}
