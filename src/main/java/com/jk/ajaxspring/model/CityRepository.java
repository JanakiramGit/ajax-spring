package com.jk.ajaxspring.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {

	List<City> findAllByState_stateId(Long stateId);

}
