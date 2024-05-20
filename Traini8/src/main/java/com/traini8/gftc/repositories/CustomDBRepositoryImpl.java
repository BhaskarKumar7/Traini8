package com.traini8.gftc.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.traini8.gftc.dtos.SearchFilter;
import com.traini8.gftc.entity.Address;
import com.traini8.gftc.entity.TrainingCenter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomDBRepositoryImpl implements CustomDBRepository {
	
	
	private final EntityManager entityManager;
	
	public CustomDBRepositoryImpl(JpaContext context) {
		this.entityManager = context.getEntityManagerByManagedType(TrainingCenter.class);
	}
	
	@Override
	public List<TrainingCenter> fetchTrainingCentersByFilter(SearchFilter filter) {
		log.info("####### CustomDBRepositoryImpl.fetchTrainingCentersByFilter #######");
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<TrainingCenter> query = builder.createQuery(TrainingCenter.class);
		Root<TrainingCenter> root = query.from(TrainingCenter.class);
		Join<TrainingCenter, Address> childJoin = root.join("address");
		
		List<Predicate> predicates = new ArrayList<>();
		if(StringUtils.hasText(filter.getCity()))	{
			log.info("+++++++++ adding city filter +++++++++");
			predicates.add(builder.equal(childJoin.get("city"), filter.getCity())); 
		}
		if(StringUtils.hasText(filter.getPincode()))	{
			log.info("+++++++ adding pincode filter +++++++");
			predicates.add(builder.equal(childJoin.get("pincode"), filter.getPincode()));
		}
		if(StringUtils.hasText(filter.getState()))	{
			log.info("+++++++++ adding state filter +++++++++");
			predicates.add(builder.equal(childJoin.get("state"), filter.getState()));
		}
		/*
		 * if(!CollectionUtils.isEmpty(filter.getCourses())) {
		 * log.info("+++++++++ adding courses filter +++++++++");
		 * filter.getCourses().forEach(course -> {
		 * predicates.add(builder.isMember(course, root.get("coursesOffered"))); });
		 * 
		 * }
		 */
		if(filter.getStudentCapacity() != null)	{
			log.info("+++++++++ adding Student Capacity filter +++++++++");
			predicates.add(builder.equal(root.get("studentCapacity"), filter.getStudentCapacity()));
		}
		if(!predicates.isEmpty())	{
			query.where(predicates.toArray(new Predicate[0]));
		}
		return entityManager.createQuery(query).getResultList();
	}

}
