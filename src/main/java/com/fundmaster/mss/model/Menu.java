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
	private Long id;
	
	@Column(name="annuityQuotationActive", nullable=false)
	private boolean annuityQuotationActive;
	
	@Column(name="potentialMemberActive", nullable=false)
	private boolean potentialMemberActive;
	
	@Column(name="potentialSponsorActive", nullable=false)
	private boolean potentialSponsorActive;
	
	@Column(name="interestRatesActive", nullable=false)
	private boolean interestRatesActive;
	
	@Column(name="whatIfAnalysisActive", nullable=false)
	private boolean whatIfAnalysisActive;
	
	@Column(name="contactUsActive", nullable=false)
	private boolean contactUsActive;
	
	@Column(name="annuityQuotationName", nullable=false)
	private String annuityQuotationName;
	
	@Column(name="potentialMemberName", nullable=false)
	private String potentialMemberName;
	
	@Column(name="potentialSponsorName", nullable=false)
	private String potentialSponsorName;
	
	@Column(name="interestRatesName", nullable=false)
	private String interestRatesName;
	
	@Column(name="whatIfAnalysisName", nullable=false)
	private String whatIfAnalysisName;
	
	@Column(name="contactUsName", nullable=false)
	private String contactUsName;
	
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
	
	public boolean isPotentialMemberActive() {
		return potentialMemberActive;
	}
	public void setPotentialMemberActive(boolean potentialMemberActive) {
		this.potentialMemberActive = potentialMemberActive;
	}
	public boolean isPotentialSponsorActive() {
		return potentialSponsorActive;
	}
	public void setPotentialSponsorActive(boolean potentialSponsorActive) {
		this.potentialSponsorActive = potentialSponsorActive;
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
	
	public String getPotentialMemberName() {
		return potentialMemberName;
	}
	public void setPotentialMemberName(String potentialMemberName) {
		this.potentialMemberName = potentialMemberName;
	}
	
	public String getPotentialSponsorName() {
		return potentialSponsorName;
	}
	public void setPotentialSponsorName(String potentialSponsorName) {
		this.potentialSponsorName = potentialSponsorName;
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
	public Menu(Long id, boolean annuityQuotationActive, boolean potentialMemberActive,
			boolean potentialSponsorActive, boolean interestRatesActive, boolean whatIfAnalysisActive,
			boolean contactUsActive, String annuityQuotationName, String potentialMemberName,
			String potentialSponsorName, String interestRatesName, String whatIfAnalysisName,
			String contactUsName) {
		super();
		this.id = id;
		this.annuityQuotationActive = annuityQuotationActive;
		this.potentialMemberActive = potentialMemberActive;
		this.potentialSponsorActive = potentialSponsorActive;
		this.interestRatesActive = interestRatesActive;
		this.whatIfAnalysisActive = whatIfAnalysisActive;
		this.contactUsActive = contactUsActive;
		this.annuityQuotationName = annuityQuotationName;
		this.potentialMemberName = potentialMemberName;
		this.potentialSponsorName = potentialSponsorName;
		this.interestRatesName = interestRatesName;
		this.whatIfAnalysisName = whatIfAnalysisName;
		this.contactUsName = contactUsName;
	}
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
