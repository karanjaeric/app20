package com.fundmaster.mss.model;

import java.io.Serializable;

public class Ordinal extends GenericModel<Ordinal> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Ordinal() {
		// TODO Auto-generated constructor stub
	}
	
	private Long id;
	private String code;
	private String name;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Ordinal(Long id, String code, String name) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
	}
	
}
