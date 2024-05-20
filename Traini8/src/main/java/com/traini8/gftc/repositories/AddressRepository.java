package com.traini8.gftc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.traini8.gftc.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Long> {

}
