package com.jk.ajaxspring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class State {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long stateId;	
	private String stateName;
	
	
	@ManyToOne
	@JoinColumn(name="countryId", nullable = false)
	@JsonIgnore
	private Country country;
	
	public State() {
		
	}	
	
	public long getStateId() {
		return stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}	

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	

}
