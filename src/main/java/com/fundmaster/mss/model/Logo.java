package com.fundmaster.mss.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Entity
@Table (name = "tbl_logo")
public class Logo extends GenericModel<Logo> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private	Long id;
	
	@Column (name = "name")
	private	String name;
	
	@Lob
	@Column (name = "image", columnDefinition = "LONGBLOB")
	private Blob image;
	
	private String path;
	
	public Logo() {
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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}
	
}
