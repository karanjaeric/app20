package com.fundmaster.mss.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table (name = "tbl_audit_trails")
public class AuditTrail extends GenericModel<AuditTrail> implements Serializable {

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDatetime() {
		return datetime;
	}

	public AuditTrail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6576381769489951304L;
	
	public String getProfile() {
		return profile;
	}

	/*public AuditTrail(long id, Date datetime, String username,
			String description, String profile, Integer version) {
		super();
		this.id = id;
		this.datetime = datetime;
		this.username = username;
		this.description = description;
		this.profile = profile;
		this.version = version;
	}*/

	public AuditTrail(String username, String profile) {
		super();
		this.username = username;
		this.profile = profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	private Date datetime;
	
	private String username;
	
	private String description;
	
	private String profile;

	@Version
	private Integer version;

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
