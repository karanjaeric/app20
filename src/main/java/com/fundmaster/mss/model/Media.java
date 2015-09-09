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
@Table (name = "tbl_media")
public class Media extends GenericModel<Media>  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Long id;
	@Column (name = "name", nullable = false)
	String name;
	@Column (name = "scheme", nullable = false)
	String schemeID;
	@Column (name="description", nullable = false)
	String description;
	@Column (name = "access", nullable = false)
	String access;
	@Column (name = "created", nullable = false)
	Date created;
	public Media() {
		// TODO Auto-generated constructor stub
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAccess() {
		return access;
	}
	public void setAccess(String access) {
		this.access = access;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Media(Long id, String name, String schemeID, String description, String access, Date created) {
		super();
		this.id = id;
		this.name = name;
		this.schemeID = schemeID;
		this.description = description;
		this.access = access;
		this.created = created;
	}
	
	

}
