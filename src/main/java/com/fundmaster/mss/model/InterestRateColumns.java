package com.fundmaster.mss.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table (name = "tbl_interest_rate_columns")
public class InterestRateColumns extends GenericModel<InterestRateColumns> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InterestRateColumns() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private
	Long id;
	private boolean dateDeclared;
	private boolean year;
	private boolean contributions;
	private boolean openingBalances;
	private boolean pensionDrawDown;
	private boolean accountingPeriod;
	private String dateDeclaredText;
	private String yearText;
	private String contributionsText;
	private String openingBalancesText;
	private String pensionDrawDownText;
	private String accountingPeriodText;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isDateDeclared() {
		return dateDeclared;
	}
	public void setDateDeclared(boolean dateDeclared) {
		this.dateDeclared = dateDeclared;
	}
	public boolean isYear() {
		return year;
	}
	public void setYear(boolean year) {
		this.year = year;
	}
	public boolean isContributions() {
		return contributions;
	}
	public void setContributions(boolean contributions) {
		this.contributions = contributions;
	}
	public boolean isOpeningBalances() {
		return openingBalances;
	}
	public void setOpeningBalances(boolean openingBalances) {
		this.openingBalances = openingBalances;
	}
	public boolean isPensionDrawDown() {
		return pensionDrawDown;
	}
	public void setPensionDrawDown(boolean pensionDrawDown) {
		this.pensionDrawDown = pensionDrawDown;
	}
	public boolean isAccountingPeriod() {
		return accountingPeriod;
	}
	public void setAccountingPeriod(boolean accountingPeriod) {
		this.accountingPeriod = accountingPeriod;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getDateDeclaredText() {
		return dateDeclaredText;
	}
	public void setDateDeclaredText(String dateDeclaredText) {
		this.dateDeclaredText = dateDeclaredText;
	}
	public String getYearText() {
		return yearText;
	}
	public void setYearText(String yearText) {
		this.yearText = yearText;
	}
	public String getContributionsText() {
		return contributionsText;
	}
	public void setContributionsText(String contributionsText) {
		this.contributionsText = contributionsText;
	}
	public String getOpeningBalancesText() {
		return openingBalancesText;
	}
	public void setOpeningBalancesText(String openingBalancesText) {
		this.openingBalancesText = openingBalancesText;
	}
	public String getPensionDrawDownText() {
		return pensionDrawDownText;
	}
	public void setPensionDrawDownText(String pensionDrawDownText) {
		this.pensionDrawDownText = pensionDrawDownText;
	}
	public String getAccountingPeriodText() {
		return accountingPeriodText;
	}
	public void setAccountingPeriodText(String accountingPeriodText) {
		this.accountingPeriodText = accountingPeriodText;
	}
	public InterestRateColumns(Long id, boolean dateDeclared, boolean year,
			boolean contributions, boolean openingBalances,
			boolean pensionDrawDown, boolean accountingPeriod,
			String dateDeclaredText, String yearText, String contributionsText,
			String openingBalancesText, String pensionDrawDownText,
			String accountingPeriodText) {
		super();
		this.id = id;
		this.dateDeclared = dateDeclared;
		this.year = year;
		this.contributions = contributions;
		this.openingBalances = openingBalances;
		this.pensionDrawDown = pensionDrawDown;
		this.accountingPeriod = accountingPeriod;
		this.dateDeclaredText = dateDeclaredText;
		this.yearText = yearText;
		this.contributionsText = contributionsText;
		this.openingBalancesText = openingBalancesText;
		this.pensionDrawDownText = pensionDrawDownText;
		this.accountingPeriodText = accountingPeriodText;
	}
	
}
