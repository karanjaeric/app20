package com.fundmaster.mss.model;

import com.fundmaster.mss.common.Constants;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table (name = "tbl_sponsors")
public class Sponsor extends GenericModel<Sponsor> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Sponsor() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private
	Long id;
	private String companyName;
	private Date applicationDate;
	private String pinNumber;
	public String getScheme() {
		return scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	private String employerRefNo;
	private Sector sector;
	private String emailAddress;
	private String phoneNumber;
	private String companyAddress;
	private String city;
	private String scheme;
	private Country country;
	private String agentId;
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId() {
		this.agentId = Constants.PROFILE_ID;
	}

	private boolean posted;

	public boolean isPosted() {
		return posted;
	}
	public void setPosted() {
		this.posted = true;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Date getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	public String getPinNumber() {
		return pinNumber;
	}
	public void setPinNumber(String pinNumber) {
		this.pinNumber = pinNumber;
	}
	public String getEmployerRefNo() {
		return employerRefNo;
	}
	public void setEmployerRefNo(String employerRefNo) {
		this.employerRefNo = employerRefNo;
	}
	public Sector getSector() {
		return sector;
	}
	public void setSector(Sector sector) {
		this.sector = sector;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Sponsor(Long id, String companyName, Date applicationDate,
			String pinNumber, String employerRefNo, Sector sector,
			String emailAddress, String phoneNumber, String companyAddress,
			String city, Country country) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.applicationDate = applicationDate;
		this.pinNumber = pinNumber;
		this.employerRefNo = employerRefNo;
		this.sector = sector;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.companyAddress = companyAddress;
		this.city = city;
		this.country = country;
	}
	
}
