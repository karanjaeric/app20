package com.fundmaster.mss.model;

import java.io.Serializable;

class DocumentType  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8914422849390618413L;
	
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

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public DocumentType() {
		super();
		// TODO Auto-generated constructor stub
	}

}
