package com.fundmaster.mss.model;

import java.io.Serializable;

public class Beneficiary implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2477489190919134392L;
	
	private long id;
	private long memberId;
	private String relationship;
	private String relShipCategory;
	private String surname;
	private String firstname;
	private String othernames;
	private String dob;
	private String gender;
	private String monthlyEntitlement;
	private String lumpsumEntitlement;
	private String idNo;
	private String postalAddress;
	private String mstatus;
	private String physicalCondition;
	private String dateOfAppointment;
	private String birthCert;
	private String guardianSn;
	private String guardianFn;
	private String guardianOn;
	private String guardianAddr;
	private String guardianGender;
	private String status;
	private String guardianRelation;
	public Beneficiary(long id, long memberId, String relationship,
			String relShipCategory, String surname, String firstname,
			String othernames, String dob, String gender,
			String monthlyEntitlement, String lumpsumEntitlement, String idNo,
			String postalAddress, String mstatus, String physicalCondition,
			String dateOfAppointment, String birthCert, String guardianSn,
			String guardianFn, String guardianOn, String guardianAddr,
			String guardianGender, String status, String guardianRelation) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.relationship = relationship;
		this.relShipCategory = relShipCategory;
		this.surname = surname;
		this.firstname = firstname;
		this.othernames = othernames;
		this.dob = dob;
		this.gender = gender;
		this.monthlyEntitlement = monthlyEntitlement;
		this.lumpsumEntitlement = lumpsumEntitlement;
		this.idNo = idNo;
		this.postalAddress = postalAddress;
		this.mstatus = mstatus;
		this.physicalCondition = physicalCondition;
		this.dateOfAppointment = dateOfAppointment;
		this.birthCert = birthCert;
		this.guardianSn = guardianSn;
		this.guardianFn = guardianFn;
		this.guardianOn = guardianOn;
		this.guardianAddr = guardianAddr;
		this.guardianGender = guardianGender;
		this.status = status;
		this.guardianRelation = guardianRelation;
	}
	public Beneficiary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public String getRelShipCategory() {
		return relShipCategory;
	}
	public void setRelShipCategory(String relShipCategory) {
		this.relShipCategory = relShipCategory;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getOthernames() {
		return othernames;
	}
	public void setOthernames(String othernames) {
		this.othernames = othernames;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMonthlyEntitlement() {
		return monthlyEntitlement;
	}
	public void setMonthlyEntitlement(String monthlyEntitlement) {
		this.monthlyEntitlement = monthlyEntitlement;
	}
	public String getLumpsumEntitlement() {
		return lumpsumEntitlement;
	}
	public void setLumpsumEntitlement(String lumpsumEntitlement) {
		this.lumpsumEntitlement = lumpsumEntitlement;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getPostalAddress() {
		return postalAddress;
	}
	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}
	public String getMstatus() {
		return mstatus;
	}
	public void setMstatus(String mstatus) {
		this.mstatus = mstatus;
	}
	public String getPhysicalCondition() {
		return physicalCondition;
	}
	public void setPhysicalCondition(String physicalCondition) {
		this.physicalCondition = physicalCondition;
	}
	public String getDateOfAppointment() {
		return dateOfAppointment;
	}
	public void setDateOfAppointment(String dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}
	public String getBirthCert() {
		return birthCert;
	}
	public void setBirthCert(String birthCert) {
		this.birthCert = birthCert;
	}
	public String getGuardianSn() {
		return guardianSn;
	}
	public void setGuardianSn(String guardianSn) {
		this.guardianSn = guardianSn;
	}
	public String getGuardianFn() {
		return guardianFn;
	}
	public void setGuardianFn(String guardianFn) {
		this.guardianFn = guardianFn;
	}
	public String getGuardianOn() {
		return guardianOn;
	}
	public void setGuardianOn(String guardianOn) {
		this.guardianOn = guardianOn;
	}
	public String getGuardianAddr() {
		return guardianAddr;
	}
	public void setGuardianAddr(String guardianAddr) {
		this.guardianAddr = guardianAddr;
	}
	public String getGuardianGender() {
		return guardianGender;
	}
	public void setGuardianGender(String guardianGender) {
		this.guardianGender = guardianGender;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGuardianRelation() {
		return guardianRelation;
	}
	public void setGuardianRelation(String guardianRelation) {
		this.guardianRelation = guardianRelation;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
