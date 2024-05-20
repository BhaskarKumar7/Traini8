package com.traini8.gftc.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.traini8.gftc.constants.AppConstants;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(schema = AppConstants.TC_SCHEMA,name = "tbl_training_center")
@Data
public class TrainingCenter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "training_center_sequence_generator")
	@SequenceGenerator(schema = AppConstants.TC_SCHEMA,sequenceName = "seq_training_center",
	name = "training_center_sequence_generator",allocationSize = 1,initialValue = 1000)
	private Long trainingCenterId;
	private String trainingCenterName;
	private String trainingCenterCode;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	private Integer studentCapacity;
	@JoinTable
	private List<String> coursesOffered;
	private LocalDateTime createdOn;
	private String contactEmail;
	private String contactPhone;
}
