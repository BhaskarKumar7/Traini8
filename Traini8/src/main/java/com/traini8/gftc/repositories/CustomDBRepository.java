package com.traini8.gftc.repositories;

import java.util.List;

import com.traini8.gftc.dtos.SearchFilter;
import com.traini8.gftc.entity.TrainingCenter;

public interface CustomDBRepository {
	public List<TrainingCenter> fetchTrainingCentersByFilter(SearchFilter filter);
}
