package com.fundmaster.mss.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table ( name = "tbl_member_rights")
public class MemberPermission extends GenericModel<MemberPermission> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private
	Long id;
	private Boolean mbio_id;
	private Boolean memberNo;
	private Boolean membershipNo;
	private Boolean partyRefNo;
	private Boolean partnerNo;
	private Boolean policyNo;
	private Boolean staffNo;
	private Boolean name;
	private Boolean idNumber;
	private Boolean terminateCover;
	private Boolean pinNo;
	private Boolean postalAddress;
	private Boolean phoneNumber;
	private Boolean emailAddress;
	private Boolean gender;
	private Boolean department;
	private Boolean dateOfBirth;
	private Boolean maritalStatus;
	private Boolean dateJoinedScheme;
	private Boolean schemeId;
	private Boolean country;
	private Boolean town;
	private Boolean region;
	private Boolean county;
	private Boolean depot;
	private Boolean designation;
	private Boolean annualPensionableSalary;
	public Long getId() {
		return id;
	}
	public MemberPermission() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberPermission(Long id, Boolean memberNo,
							Boolean partyRefNo, Boolean partnerNo, Boolean policyNo,
							Boolean staffNo, Boolean name, Boolean idNumber,
							Boolean pinNo, Boolean postalAddress,
							Boolean phoneNumber, Boolean emailAddress, Boolean gender,
							Boolean dateOfBirth, Boolean maritalStatus,
							Boolean country, Boolean department, Boolean designation,
							Boolean town, Boolean annualPensionableSalary, Boolean region, Boolean county,
							Boolean depot) {
		super();
		this.id = id;
		this.mbio_id = false;
		this.memberNo = memberNo;
		this.membershipNo = false;
		this.partyRefNo = partyRefNo;
		this.partnerNo = partnerNo;
		this.policyNo = policyNo;
		this.staffNo = staffNo;
		this.name = name;
		this.idNumber = idNumber;
		this.terminateCover = false;
		this.pinNo = pinNo;
		this.postalAddress = postalAddress;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.gender = gender;
		this.department = department;
		this.designation = designation;
		this.dateOfBirth = dateOfBirth;
		this.maritalStatus = maritalStatus;
		this.dateJoinedScheme = false;
		this.schemeId = false;
		this.country = country;
		this.town = town;
		this.annualPensionableSalary = annualPensionableSalary;
		this.region = region;
		this.county = county;
		this.depot = depot;
	}

	public Boolean getCounty() {
		return county;
	}

	public void setCounty(Boolean county) {
		this.county = county;
	}

	public Boolean getDepot() {
		return depot;
	}

	public void setDepot(Boolean depot) {
		this.depot = depot;
	}
	public Boolean getDesignation() {return designation;}
	public void setDesignation(Boolean designation) {this.designation = designation;}
	public Boolean getRegion() {return region;}
	public void setRegion(Boolean region) {this.region = region;}
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
