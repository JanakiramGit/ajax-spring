package com.jk.ajaxspring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cityId;	
	private String cityName;
	
	
	@ManyToOne
	@JoinColumn(name="stateId", nullable = false)
	@JsonIgnore
	private State state;
	
	public City() {
		
	}	
	
	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}	

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	

}
