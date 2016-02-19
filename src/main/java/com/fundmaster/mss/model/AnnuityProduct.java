package com.fundmaster.mss.model;

import java.io.Serializable;

public class AnnuityProduct extends GenericModel<AnnuityProduct> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AnnuityProduct() {
		// TODO Auto-generated constructor stub
	}

	private Long id;
	private String productName;
	private String productDate;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDate() {
		return productDate;
	}
	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public AnnuityProduct(Long id, String productName, String productDate) {
		super();
		this.id = id;
		this.productName = productName;
		this.productDate = productDate;
	}
	
}
