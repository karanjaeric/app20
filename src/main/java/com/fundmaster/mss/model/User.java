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
@Table (name = "tbl_users")
public class User extends GenericModel<User>  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private
	Long id;
	private String userProfile;
	private Long profileID;
	@Column (unique = true)
	private String username;
	private String password;
	private Date password_expiry;
	public int getAttempt() {
		return attempt;
	}
	public Date getPassword_expiry() {
		return password_expiry;
	}
	public void setPassword_expiry(Date password_expiry) {
		this.password_expiry = password_expiry;
	}
	public void setAttempt(int attempt) {
		this.attempt = attempt;
	}
	private int attempt;
	private String securityCode;
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	private boolean status;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}
	public Long getProfileID() {
		return profileID;
	}
	public void setProfileID(Long profileID) {
		this.profileID = profileID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static Long getSerialversionuid() {
		return serialVersionUID;
	}
	public User(String userProfile, Long profileID, String username,
				String password) {
		super();
		this.id = null;
		this.userProfile = userProfile;
		this.profileID = profileID;
		this.username = username;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
