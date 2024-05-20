package com.traini8.gftc.entity;

import com.traini8.gftc.constants.AppConstants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(schema = AppConstants.TC_SCHEMA, name = "tbl_address")
@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "address_sequence_generator")
	@SequenceGenerator(schema = AppConstants.TC_SCHEMA,sequenceName = "seq_address",
	name = "address_sequence_generator",initialValue = 1000,allocationSize = 1)
	private Long addressId;
	@Column(length = 1000)
	private String detailedAddress;
	private String city;
	private String state;
	private String pincode;
}
