package com.traini8.gftc.service;

import java.util.List;

import com.traini8.gftc.dtos.SearchFilter;
import com.traini8.gftc.dtos.TrainingCenterDto;

public interface TrainingCenterService {
	public TrainingCenterDto saveTrainingCentre(TrainingCenterDto trainingCenterDto);
	public Boolean doesEmailExists(String email);
	public Boolean doesMobileNoExists(String mobileNo);
	public List<TrainingCenterDto> fetchAllTrainingCenters(SearchFilter filter);
}
