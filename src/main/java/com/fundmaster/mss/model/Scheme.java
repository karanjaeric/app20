package com.fundmaster.mss.model;

import java.io.Serializable;
public class Scheme extends GenericModel<Scheme> implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Scheme() {
		// TODO Auto-generated constructor stub
	}
	
	Long id;
	String code;
	String name;
	String schemeType;
	String schemePin;
	String planType;
	String sector;
	public Long getId() {
		return id;
	}

	public String getSchemeType() {
		return schemeType;
	}

	public void setSchemeType(String schemeType) {
		this.schemeType = schemeType;
	}

	public String getSchemePin() {
		return schemePin;
	}

	public void setSchemePin(String schemePin) {
		this.schemePin = schemePin;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Scheme(Long id, String code, String name, String schemeType,
			String schemePin, String planType, String sector) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.schemeType = schemeType;
		this.schemePin = schemePin;
		this.planType = planType;
		this.sector = sector;
	}

	
	
}
