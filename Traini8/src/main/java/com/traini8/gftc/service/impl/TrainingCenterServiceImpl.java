package com.traini8.gftc.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traini8.gftc.dtos.AddressDto;
import com.traini8.gftc.dtos.SearchFilter;
import com.traini8.gftc.dtos.TrainingCenterDto;
import com.traini8.gftc.entity.Address;
import com.traini8.gftc.entity.TrainingCenter;
import com.traini8.gftc.repositories.TrainingCenterRepository;
import com.traini8.gftc.service.TrainingCenterService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TrainingCenterServiceImpl implements TrainingCenterService {

	@Autowired
	private TrainingCenterRepository trainingCenterRepository;

	@Override
	public TrainingCenterDto saveTrainingCentre(TrainingCenterDto trainingCenterDto) {
		log.info("=========== preparing entity from training center dto ===========");
		TrainingCenter trainingCenter = new TrainingCenter();
		Address address = new Address();
		trainingCenter.setTrainingCenterName(trainingCenterDto.getTrainingCenterName());
		trainingCenter.setTrainingCenterCode(trainingCenterDto.getTrainingCenterCode());

		AddressDto addressDto = trainingCenterDto.getAddress();
		address.setDetailedAddress(addressDto.getDetailedAddress());
		address.setCity(addressDto.getCity());
		address.setState(addressDto.getState());
		address.setPincode(addressDto.getPincode());

		trainingCenter.setAddress(address);
		trainingCenter.setStudentCapacity(Integer.parseInt(trainingCenterDto.getStudentCapacity()));
		trainingCenter.setCoursesOffered(trainingCenterDto.getCoursesOffered());
		trainingCenter.setCreatedOn(LocalDateTime.now());
		trainingCenter.setContactEmail(trainingCenterDto.getContactEmail());
		trainingCenter.setContactPhone(trainingCenterDto.getContactPhone());

		log.info("======== saving the training center dto =======");
		trainingCenter = trainingCenterRepository.save(trainingCenter);
		BeanUtils.copyProperties(trainingCenter, trainingCenterDto);
		return trainingCenterDto;
	}

	
	@Override
	public Boolean doesEmailExists(String email) {
		return trainingCenterRepository
				.findByContactEmail(email) == null ? false : true;
	}

	@Override
	public Boolean doesMobileNoExists(String mobileNo) {
		return trainingCenterRepository
				.findByContactPhone(mobileNo) == null ? false : true;
	}


	@Override
	public List<TrainingCenterDto> fetchAllTrainingCenters(SearchFilter filter) {
		List<TrainingCenter> trainingCentersList = null;
		log.info("========= Fetching all training centers from database ========");
		trainingCentersList = trainingCenterRepository.fetchTrainingCentersByFilter(filter);
		TrainingCenter trainingCenter = null;
		Address address = null;
		List<TrainingCenterDto> trainingCenterDtosList = new ArrayList<>();
		log.info("======= converting training centers entities to dto list =======");
		for(int i=0;i<trainingCentersList.size();i++) {
			TrainingCenterDto trainingCenterDto = new TrainingCenterDto();
			AddressDto addressDto = new AddressDto();
			trainingCenter = trainingCentersList.get(i);
			address = trainingCenter.getAddress();
			/* Setting training center entity properties to training center dto*/
			BeanUtils.copyProperties(trainingCenter, trainingCenterDto);
			/*Setting address entity properties to address dto*/
			BeanUtils.copyProperties(address, addressDto);
			/*Setting addressDto to training center dto seperately becoz it is a nested property*/
			trainingCenterDto.setAddress(addressDto);
			/*Setting student capacity to training center dto manually because of data type conflict*/
			trainingCenterDto.setStudentCapacity(trainingCenter.getStudentCapacity().toString());
			trainingCenterDtosList.add(trainingCenterDto);
		}
		return trainingCenterDtosList;
	}

}
