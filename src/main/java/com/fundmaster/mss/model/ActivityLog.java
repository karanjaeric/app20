package com.fundmaster.mss.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table (name = "tbl_activity_logs")
public class ActivityLog extends GenericModel<ActivityLog> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActivityLog() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Long id;
	@Column (name = "description", nullable = false)
	String description;
	@Column (name = "userProfile", nullable = true)
	String userProfile;
	@Column (name = "datetime", nullable = false)
	Date datetime;
	@Column (name = "user_id", nullable = true)
	Long userID;
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public String getAccess_menu() {
		return access_menu;
	}
	public void setAccess_menu(String access_menu) {
		this.access_menu = access_menu;
	}

	public String getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}

	@Column (name = "scheme", nullable = true)
	String scheme;
	String access_menu;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public String getScheme() {
		return scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ActivityLog(Long id, String description, Date datetime,
			Long userID, String scheme, String access_menu, String userProfile) {
		super();
		this.id = id;
		this.description = description;
		this.datetime = datetime;
		this.userID = userID;
		this.scheme = scheme;
		this.access_menu = access_menu;
		this.userProfile = userProfile;
	}
	
}
