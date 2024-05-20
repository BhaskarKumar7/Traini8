package com.traini8.gftc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.traini8.gftc.entity.TrainingCenter;
import java.util.List;




public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long>,CustomDBRepository {
	TrainingCenter findByContactEmail(String contactEmail);
	TrainingCenter findByContactPhone(String contactPhone);
	List<TrainingCenter> findByAddress_Pincode(String pincode);
	List<TrainingCenter> findByAddress_State(String state);
	List<TrainingCenter> findByAddress_City(String city);
}
