package com.fundmaster.mss.model;

import java.io.Serializable;

class InterestRate extends GenericModel<InterestRate> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InterestRate() {
		// TODO Auto-generated constructor stub
	}

	private Long id;
	private String dateDeclared;
	private String year;
	private String contributions;
	private String openingBalances;
	private String pensionDrawnDown;
	private String counter;
	private String accountingPeriod;
	private String status;
	private String sponsor;
	private String type;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDateDeclared() {
		return dateDeclared;
	}
	public void setDateDeclared(String dateDeclared) {
		this.dateDeclared = dateDeclared;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getContributions() {
		return contributions;
	}
	public void setContributions(String contributions) {
		this.contributions = contributions;
	}
	public String getOpeningBalances() {
		return openingBalances;
	}
	public void setOpeningBalances(String openingBalances) {
		this.openingBalances = openingBalances;
	}
	public String getPensionDrawnDown() {
		return pensionDrawnDown;
	}
	public void setPensionDrawnDown(String pensionDrawnDown) {
		this.pensionDrawnDown = pensionDrawnDown;
	}
	public String getCounter() {
		return counter;
	}
	public void setCounter(String counter) {
		this.counter = counter;
	}
	public String getAccountingPeriod() {
		return accountingPeriod;
	}
	public void setAccountingPeriod(String accountingPeriod) {
		this.accountingPeriod = accountingPeriod;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSponsor() {
		return sponsor;
	}
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public InterestRate(Long id, String dateDeclared, String year,
			String contributions, String openingBalances,
			String pensionDrawnDown, String counter, String accountingPeriod,
			String status, String sponsor, String type) {
		super();
		this.id = id;
		this.dateDeclared = dateDeclared;
		this.year = year;
		this.contributions = contributions;
		this.openingBalances = openingBalances;
		this.pensionDrawnDown = pensionDrawnDown;
		this.counter = counter;
		this.accountingPeriod = accountingPeriod;
		this.status = status;
		this.sponsor = sponsor;
		this.type = type;
	}
	
	
}
