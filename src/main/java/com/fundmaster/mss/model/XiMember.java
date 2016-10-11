package com.fundmaster.mss.model;

import java.io.Serializable;

public class XiMember extends GenericModel<XiMember> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public XiMember() {
		// TODO Auto-generated constructor stub
	}

	
	private Long id;
	private String mbio_id;
	private String memberNo;
	private String othernames;
	private String membershipNo;
	private String firstname;
	private String surname;
	private String title;
	private String partyRefNo;
	private String partnerNo;
	private String policyNo;
	private String staffNo;
	private String name;
	private String idNumber;
	private String terminateCover;
	private String pinNo;
	private String postalAddress;
	private String phoneNumber;
	private String emailAddress;
	private String gender;
	private String department;
	private String dateOfBirth;
	private String maritalStatus;
	private String dateJoinedScheme;
	private String schemeId;
	private String country;
	private String town;
	private String annualPensionableSalary;
	private String profile;
	private String region;
	private String county;
	private String depot;
	private String designation;
	private String mbshipStatus;

	public String getMbshipStatus() {
		return mbshipStatus;
	}

	public void setMbshipStatus(String mbshipStatus) {
		this.mbshipStatus = mbshipStatus;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getDepot() {
		return depot;
	}

	public void setDepot(String depot) {
		this.depot = depot;
	}
	public String getDesignation() {return designation;}
	public void setDesignation(String designation) {this.designation = designation;}
	public String getRegion() {return region;}
	public void setRegion(String region) {this.region = region;}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getOthernames() {
		return othernames;
	}
	public void setOthernames(String othernames) {
		this.othernames = othernames;
	}
	public String getPartnerNo() {
		return partnerNo;
	}
	public void setPartnerNo(String partnerNo) {
		this.partnerNo = partnerNo;
	}
	public String getAnnualPensionableSalary() {
		return annualPensionableSalary;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAnnualPensionableSalary(String annualPensionableSalary) {
		this.annualPensionableSalary = annualPensionableSalary;
	}
	public Long getId() {
		return id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMbio_id() {
		return mbio_id;
	}
	public void setMbio_id(String mbio_id) {
		this.mbio_id = mbio_id;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getMembershipNo() {
		return membershipNo;
	}
	public void setMembershipNo(String membershipNo) {
		this.membershipNo = membershipNo;
	}
	public String getPartyRefNo() {
		return partyRefNo;
	}
	public void setPartyRefNo(String partyRefNo) {
		this.partyRefNo = partyRefNo;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getStaffNo() {
		return staffNo;
	}
	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getTerminateCover() {
		return terminateCover;
	}
	public void setTerminateCover(String terminateCover) {
		this.terminateCover = terminateCover;
	}
	public String getPinNo() {
		return pinNo;
	}
	public void setPinNo(String pinNo) {
		this.pinNo = pinNo;
	}
	public String getPostalAddress() {
		return postalAddress;
	}
	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getDateJoinedScheme() {
		return dateJoinedScheme;
	}
	public void setDateJoinedScheme(String dateJoinedScheme) {
		this.dateJoinedScheme = dateJoinedScheme;
	}
	public String getSchemeId() {
		return schemeId;
	}
	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public XiMember(Long id, String mbio_id, String memberNo,
			String membershipNo, String partyRefNo, String partnerNo, String policyNo,
			String staffNo, String name, String idNumber,
			String terminateCover, String pinNo, String postalAddress,
			String phoneNumber, String emailAddress, String gender,
			String department, String dateOfBirth, String maritalStatus,
			String dateJoinedScheme, String schemeId, String town, String country, String annualPensionableSalary,
			String firstname, String surname, String othernames, String region, String designation, String county,
					String depot, String mbshipStatus) {
		super();
		this.id = id;
		this.mbio_id = mbio_id;
		this.memberNo = memberNo;
		this.membershipNo = membershipNo;
		this.partyRefNo = partyRefNo;
		this.partnerNo = partnerNo;
		this.policyNo = policyNo;
		this.staffNo = staffNo;
		this.name = name;
		this.idNumber = idNumber;
		this.terminateCover = terminateCover;
		this.pinNo = pinNo;
		this.postalAddress = postalAddress;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.gender = gender;
		this.department = department;
		this.dateOfBirth = dateOfBirth;
		this.maritalStatus = maritalStatus;
		this.dateJoinedScheme = dateJoinedScheme;
		this.schemeId = schemeId;
		this.town = town;
		this.country = country;
		this.annualPensionableSalary = annualPensionableSalary;
		this.firstname = firstname;
		this.surname = surname;
		this.othernames = othernames;
		this.region = region;
		this.designation = designation;
		this.county = county;
		this.depot = depot;
		this.mbshipStatus = mbshipStatus;
	}
	
}
