package com.fundmaster.mss.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "tbl_genders")
public class Gender extends GenericModel<Gender>  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private
	Long id;
	@Column (name = "name", nullable = false)
	private
	String name;
	public Gender() {
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
	public Gender(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
