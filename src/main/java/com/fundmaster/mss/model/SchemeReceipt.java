package com.fundmaster.mss.model;

import java.io.Serializable;

public class SchemeReceipt extends GenericModel<SchemeReceipt> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String date;
	private String valueDate;
	private String payee;
	private String amount;
	private String category;
	private String type;
	private String mode;
	private String ref;
	private String receipt_no;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public SchemeReceipt() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getValueDate() {
		return valueDate;
	}

	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getReceipt_no() {
		return receipt_no;
	}

	public void setReceipt_no(String receipt_no) {
		this.receipt_no = receipt_no;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SchemeReceipt(String date, String valueDate, String payee, String amount,
			String category, String type, String mode, String ref,
			String receipt_no) {
		super();
		this.date = date;
		this.valueDate=valueDate;
		this.payee = payee;
		this.amount = amount;
		this.category = category;
		this.type = type;
		this.mode = mode;
		this.ref = ref;
		this.receipt_no = receipt_no;
	}
	
	

}
