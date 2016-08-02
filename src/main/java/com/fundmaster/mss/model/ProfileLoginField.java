package com.fundmaster.mss.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table (name = "tbl_profile_login_fields")
public class ProfileLoginField extends GenericModel<ProfileLoginField> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	private String profile;
	
	private String ordinal;
	
	private boolean published;
	
	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public ProfileLoginField() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProfileLoginField(long id, String profile, String ordinal) {
		super();
		this.id = id;
		this.profile = profile;
		this.ordinal = ordinal;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(String ordinal) {
		this.ordinal = ordinal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
