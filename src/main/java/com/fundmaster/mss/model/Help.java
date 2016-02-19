package com.fundmaster.mss.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table (name = "tbl_help")
public class Help extends GenericModel<Help> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Help() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private
	Long id;
	@Column (name = "page", nullable = false)
	private
	String page;
	@Column (name = "description", nullable = false, columnDefinition = "TEXT")
	private
	String description;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
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
	public Help(Long id, String page, String description) {
		super();
		this.id = id;
		this.page = page;
		this.description = description;
	}
	
	
	
}
