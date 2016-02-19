package com.fundmaster.mss.model;

import java.io.Serializable;

public class UserProfile extends GenericModel<UserProfile> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserProfile() {
		// TODO Auto-generated constructor stub
	}
	
	private Long id;
	private String name;

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
	public UserProfile(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
