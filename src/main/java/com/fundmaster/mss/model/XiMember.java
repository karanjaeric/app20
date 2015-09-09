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

	
	Long id;
	String mbio_id, memberNo, othernames, membershipNo, firstname, surname, title,  partyRefNo, partnerNo, policyNo, staffNo, name, idNumber, terminateCover, pinNo, postalAddress, phoneNumber, emailAddress, gender, department, dateOfBirth, maritalStatus, dateJoinedScheme, schemeId, country, town, annualPensionableSalary;

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
			String dateJoinedScheme, String schemeId, String town, String country, String annualPensionableSalary, String firstname, String surname, String othernames) {
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
	}
	
}
