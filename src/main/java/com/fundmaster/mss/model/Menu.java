package com.fundmaster.mss.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_menus")
public class Menu  extends GenericModel<Member>   implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column(name="annuityQuotationActive", nullable=false)
	boolean annuityQuotationActive;
	@Column(name="interestRatesActive", nullable=false)
	boolean interestRatesActive;
	@Column(name="whatIfAnalysisActive", nullable=false)
	boolean whatIfAnalysisActive;
	@Column(name="contactUsActive", nullable=false)
	boolean contactUsActive;
	@Column(name="annuityQuotationName", nullable=false)
	String annuityQuotationName;
	@Column(name="interestRatesName", nullable=false)
	String interestRatesName;
	@Column(name="whatIfAnalysisName", nullable=false)
	String whatIfAnalysisName;
	@Column(name="contactUsName", nullable=false)
	String contactUsName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isAnnuityQuotationActive() {
		return annuityQuotationActive;
	}
	public void setAnnuityQuotationActive(boolean annuityQuotationActive) {
		this.annuityQuotationActive = annuityQuotationActive;
	}
	public boolean isInterestRatesActive() {
		return interestRatesActive;
	}
	public void setInterestRatesActive(boolean interestRatesActive) {
		this.interestRatesActive = interestRatesActive;
	}
	public boolean isWhatIfAnalysisActive() {
		return whatIfAnalysisActive;
	}
	public void setWhatIfAnalysisActive(boolean whatIfAnalysisActive) {
		this.whatIfAnalysisActive = whatIfAnalysisActive;
	}
	public boolean isContactUsActive() {
		return contactUsActive;
	}
	public void setContactUsActive(boolean contactUsActive) {
		this.contactUsActive = contactUsActive;
	}
	public String getAnnuityQuotationName() {
		return annuityQuotationName;
	}
	public void setAnnuityQuotationName(String annuityQuotationName) {
		this.annuityQuotationName = annuityQuotationName;
	}
	public String getInterestRatesName() {
		return interestRatesName;
	}
	public void setInterestRatesName(String interestRatesName) {
		this.interestRatesName = interestRatesName;
	}
	public String getWhatIfAnalysisName() {
		return whatIfAnalysisName;
	}
	public void setWhatIfAnalysisName(String whatIfAnalysisName) {
		this.whatIfAnalysisName = whatIfAnalysisName;
	}
	public String getContactUsName() {
		return contactUsName;
	}
	public void setContactUsName(String contactUsName) {
		this.contactUsName = contactUsName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Menu(Long id, boolean annuityQuotationActive,
			boolean interestRatesActive, boolean whatIfAnalysisActive,
			boolean contactUsActive, String annuityQuotationName,
			String interestRatesName, String whatIfAnalysisName,
			String contactUsName) {
		super();
		this.id = id;
		this.annuityQuotationActive = annuityQuotationActive;
		this.interestRatesActive = interestRatesActive;
		this.whatIfAnalysisActive = whatIfAnalysisActive;
		this.contactUsActive = contactUsActive;
		this.annuityQuotationName = annuityQuotationName;
		this.interestRatesName = interestRatesName;
		this.whatIfAnalysisName = whatIfAnalysisName;
		this.contactUsName = contactUsName;
	}
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
