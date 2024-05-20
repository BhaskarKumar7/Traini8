package com.traini8.gftc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.traini8.gftc.dtos.SearchFilter;
import com.traini8.gftc.dtos.TrainingCenterDto;
import com.traini8.gftc.service.TrainingCenterService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
@Validated
public class TrainingCenterController {
	
	@Autowired
	private TrainingCenterService trainingCenterService;

	@PostMapping("/trainingCenter")
	public ResponseEntity<TrainingCenterDto> saveTrainingCenter(@RequestBody
			@Valid TrainingCenterDto trainingCenterDto){
		log.info("------- TrainingCenterController.saveTrainingCenter --------");
		log.info("training center req payload -> {}",trainingCenterDto);
		return new ResponseEntity<>(trainingCenterService
				.saveTrainingCentre(trainingCenterDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/trainingCentersList")
	public ResponseEntity<Map<String, List<TrainingCenterDto>>>  fetchAllTrainingCentersList(
			@RequestParam(required = false) Integer studentCapacity,
			@RequestParam(required = false) String city,
			@RequestParam(required = false) String state,
			@RequestParam(required = false)String pincode
			/*@RequestParam(required = false) List<String> courses*/){
		log.info("------- TrainingCenterController.fetchAllTrainingCentersList -------");
		
		SearchFilter filter = new SearchFilter();
		filter.setCity(city);
		/* filter.setCourses(courses); */
		filter.setPincode(pincode);
		filter.setState(state);
		filter.setStudentCapacity(studentCapacity);
		
       List<TrainingCenterDto> trainingCenterDtosList = 
    		   trainingCenterService.fetchAllTrainingCenters(filter);
       Map<String, List<TrainingCenterDto>> responseMap = new HashMap<>();
       responseMap.put("trainingCentersDtosList", trainingCenterDtosList);
       return new ResponseEntity<>(responseMap,HttpStatus.OK);
	}
}
