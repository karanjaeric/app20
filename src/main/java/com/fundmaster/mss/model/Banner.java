package com.fundmaster.mss.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
@Entity
@Table (name = "tbl_banners")
public class Banner extends GenericModel<Banner> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private	Long id;
	
	@Column (name = "name", nullable = false)
	private	String name;
	
	@Lob
	@Column (name = "image", columnDefinition = "LONGBLOB")
	private Blob image;
  //private byte[] image;
	
	private String path;
	
	public Banner() {
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

	/*public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}*/
	
}
