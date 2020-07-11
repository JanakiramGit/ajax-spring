package com.jk.ajaxspring.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {

	List<State> findAllByCountry_countryId(Long countryId);

}
