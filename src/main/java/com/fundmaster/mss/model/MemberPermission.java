package com.fundmaster.mss.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table ( name = "tbl_member_rights")
public class MemberPermission extends GenericModel<MemberPermission> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Long id;
	Boolean mbio_id, memberNo, membershipNo, partyRefNo, partnerNo, policyNo, staffNo, name, idNumber, terminateCover, pinNo, postalAddress, phoneNumber, emailAddress, gender, department, dateOfBirth, maritalStatus, dateJoinedScheme, schemeId, country, town, annualPensionableSalary;
	public Long getId() {
		return id;
	}
	public MemberPermission() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberPermission(Long id, Boolean mbio_id, Boolean memberNo,
			Boolean membershipNo, Boolean partyRefNo, Boolean partnerNo, Boolean policyNo,
			Boolean staffNo, Boolean name, Boolean idNumber,
			Boolean terminateCover, Boolean pinNo, Boolean postalAddress,
			Boolean phoneNumber, Boolean emailAddress, Boolean gender,
			Boolean department, Boolean dateOfBirth, Boolean maritalStatus,
			Boolean dateJoinedScheme, Boolean schemeId, Boolean country,
			Boolean town, Boolean annualPensionableSalary) {
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
		this.country = country;
		this.town = town;
		this.annualPensionableSalary = annualPensionableSalary;
	}
	public Boolean getPartnerNo() {
		return partnerNo;
	}
	public void setPartnerNo(Boolean partnerNo) {
		this.partnerNo = partnerNo;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getMbio_id() {
		return mbio_id;
	}
	public void setMbio_id(Boolean mbio_id) {
		this.mbio_id = mbio_id;
	}
	public Boolean getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Boolean memberNo) {
		this.memberNo = memberNo;
	}
	public Boolean getMembershipNo() {
		return membershipNo;
	}
	public void setMembershipNo(Boolean membershipNo) {
		this.membershipNo = membershipNo;
	}
	public Boolean getPartyRefNo() {
		return partyRefNo;
	}
	public void setPartyRefNo(Boolean partyRefNo) {
		this.partyRefNo = partyRefNo;
	}
	public Boolean getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(Boolean policyNo) {
		this.policyNo = policyNo;
	}
	public Boolean getStaffNo() {
		return staffNo;
	}
	public void setStaffNo(Boolean staffNo) {
		this.staffNo = staffNo;
	}
	public Boolean getName() {
		return name;
	}
	public void setName(Boolean name) {
		this.name = name;
	}
	public Boolean getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(Boolean idNumber) {
		this.idNumber = idNumber;
	}
	public Boolean getTerminateCover() {
		return terminateCover;
	}
	public void setTerminateCover(Boolean terminateCover) {
		this.terminateCover = terminateCover;
	}
	public Boolean getPinNo() {
		return pinNo;
	}
	public void setPinNo(Boolean pinNo) {
		this.pinNo = pinNo;
	}
	public Boolean getPostalAddress() {
		return postalAddress;
	}
	public void setPostalAddress(Boolean postalAddress) {
		this.postalAddress = postalAddress;
	}
	public Boolean getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Boolean phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Boolean getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(Boolean emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	public Boolean getDepartment() {
		return department;
	}
	public void setDepartment(Boolean department) {
		this.department = department;
	}
	public Boolean getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Boolean dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Boolean getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(Boolean maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public Boolean getDateJoinedScheme() {
		return dateJoinedScheme;
	}
	public void setDateJoinedScheme(Boolean dateJoinedScheme) {
		this.dateJoinedScheme = dateJoinedScheme;
	}
	public Boolean getSchemeId() {
		return schemeId;
	}
	public void setSchemeId(Boolean schemeId) {
		this.schemeId = schemeId;
	}
	public Boolean getCountry() {
		return country;
	}
	public void setCountry(Boolean country) {
		this.country = country;
	}
	public Boolean getTown() {
		return town;
	}
	public void setTown(Boolean town) {
		this.town = town;
	}
	public Boolean getAnnualPensionableSalary() {
		return annualPensionableSalary;
	}
	public void setAnnualPensionableSalary(Boolean annualPensionableSalary) {
		this.annualPensionableSalary = annualPensionableSalary;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
