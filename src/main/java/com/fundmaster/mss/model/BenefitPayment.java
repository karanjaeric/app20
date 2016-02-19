package com.fundmaster.mss.model;

import java.io.Serializable;

public class BenefitPayment extends GenericModel<BenefitPayment> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String gross;
	private String taxFree;
	private String taxable;
	private String withHolding;
	private String net;
	private String dateApproved;
	private String dateOfCalc;
	private String type;
	private String payee;

	public String getGross() {
		return gross;
	}

	public void setGross(String gross) {
		this.gross = gross;
	}

	public String getTaxFree() {
		return taxFree;
	}

	public BenefitPayment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setTaxFree(String taxFree) {
		this.taxFree = taxFree;
	}

	public String getTaxable() {
		return taxable;
	}

	public void setTaxable(String taxable) {
		this.taxable = taxable;
	}

	public String getWithHolding() {
		return withHolding;
	}

	public void setWithHolding(String withHolding) {
		this.withHolding = withHolding;
	}

	public String getNet() {
		return net;
	}

	public void setNet(String net) {
		this.net = net;
	}

	public String getDateApproved() {
		return dateApproved;
	}

	public void setDateApproved(String dateApproved) {
		this.dateApproved = dateApproved;
	}

	public String getDateOfCalc() {
		return dateOfCalc;
	}

	public void setDateOfCalc(String dateOfCalc) {
		this.dateOfCalc = dateOfCalc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BenefitPayment(String gross, String taxFree, String taxable,
			String withHolding, String net, String dateApproved,
			String dateOfCalc, String type, String payee) {
		super();
		this.gross = gross;
		this.taxFree = taxFree;
		this.taxable = taxable;
		this.withHolding = withHolding;
		this.net = net;
		this.dateApproved = dateApproved;
		this.dateOfCalc = dateOfCalc;
		this.type = type;
		this.payee = payee;
	}
	
	

}
