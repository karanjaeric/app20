package com.fundmaster.mss.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "tbl_contact_categories")
public class ContactCategory extends GenericModel<ContactCategory> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4078576558266026547L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public ContactCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Version
	private Integer version;

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public ContactCategory(long id, String name, Integer version) {
		super();
		this.id = id;
		this.name = name;
		this.version = version;
	}

}
