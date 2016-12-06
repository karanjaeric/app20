package com.fundmaster.mss.model;

import java.io.Serializable;

/**
 * Created by tony on 11/24/16.
 */
public class XiPensioner extends GenericModel<XiPensioner> implements Serializable {

    private static final long serialVersionUID = 1L;

    public XiPensioner() {

    }

    private Long id;
    private String pensionerNo;
    private String pensionFrequency;
    private String name;
    private String email;
    private String tax;
    private String memberNo;
    private String memberId;
    private  String schemeId;
    private String pinNo;
    private String idNo;
    private String reason;
    private String dob;
    private String gender;
    private String purchasePrice;
    private String guaranteedPeriod;
    private String pensionStatus;
    private String pensionStartDate;
    private String pensionStopDate;
    private String payType;
    private String monthlyPension;
    private String monthlyPension2;
    private String totalPension;  //pension
    private String partnerNumber;
    private String alive;
    private String postalAddress;
    private String town;
    private String bankName;
    private String branch;
    private String country;
    private String commissionPaid;
    private String accountName;
    private String accountNumber;
    private String pensionerType;
    private String dateOfCalculation;
    private String certificateRecieved;
    private String dateReceived;
    private String dateLastPaid;
    private String dateLastEncashment;
    private String unreturnedCheques;
    private String beneficiariesPaymentMode;
    private String freqEffectiveDate;
    private String arrearsPaymentMode;
    private String cellPhone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPensionerNo() {
        return pensionerNo;
    }

    public void setPensionerNo(String pensionerNo) {
        this.pensionerNo = pensionerNo;
    }

    public String getPensionFrequency() {
        return pensionFrequency;
    }

    public void setPensionFrequency(String pensionFrequency) {
        this.pensionFrequency = pensionFrequency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getPinNo() {
        return pinNo;
    }

    public void setPinNo(String pinNo) {
        this.pinNo = pinNo;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getGuaranteedPeriod() {
        return guaranteedPeriod;
    }

    public void setGuaranteedPeriod(String guaranteedPeriod) {
        this.guaranteedPeriod = guaranteedPeriod;
    }

    public String getPensionStatus() {
        return pensionStatus;
    }

    public void setPensionStatus(String pensionStatus) {
        this.pensionStatus = pensionStatus;
    }

    public String getPensionStartDate() {
        return pensionStartDate;
    }

    public void setPensionStartDate(String pensionStartDate) {
        this.pensionStartDate = pensionStartDate;
    }

    public String getPensionStopDate() {
        return pensionStopDate;
    }

    public void setPensionStopDate(String pensionStopDate) {
        this.pensionStopDate = pensionStopDate;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getMonthlyPension() {
        return monthlyPension;
    }

    public void setMonthlyPension(String monthlyPension) {
        this.monthlyPension = monthlyPension;
    }

    public String getMonthlyPension2() {
        return monthlyPension2;
    }

    public void setMonthlyPension2(String monthlyPension2) {
        this.monthlyPension2 = monthlyPension2;
    }

    public String getTotalPension() {
        return totalPension;
    }

    public void setTotalPension(String totalPension) {
        this.totalPension = totalPension;
    }

    public String getPartnerNumber() {
        return partnerNumber;
    }

    public void setPartnerNumber(String partnerNumber) {
        this.partnerNumber = partnerNumber;
    }

    public String getAlive() {
        return alive;
    }

    public void setAlive(String alive) {
        this.alive = alive;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCommissionPaid() {
        return commissionPaid;
    }

    public void setCommissionPaid(String commissionPaid) {
        this.commissionPaid = commissionPaid;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPensionerType() {
        return pensionerType;
    }

    public void setPensionerType(String pensionerType) {
        this.pensionerType = pensionerType;
    }

    public String getDateOfCalculation() {
        return dateOfCalculation;
    }

    public void setDateOfCalculation(String dateOfCalculation) {
        this.dateOfCalculation = dateOfCalculation;
    }

    public String getCertificateRecieved() {
        return certificateRecieved;
    }

    public void setCertificateRecieved(String certificateRecieved) {
        this.certificateRecieved = certificateRecieved;
    }

    public String getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }

    public String getDateLastPaid() {
        return dateLastPaid;
    }

    public void setDateLastPaid(String dateLastPaid) {
        this.dateLastPaid = dateLastPaid;
    }

    public String getDateLastEncashment() {
        return dateLastEncashment;
    }

    public void setDateLastEncashment(String dateLastEncashment) {
        this.dateLastEncashment = dateLastEncashment;
    }

    public String getUnreturnedCheques() {
        return unreturnedCheques;
    }

    public void setUnreturnedCheques(String unreturnedCheques) {
        this.unreturnedCheques = unreturnedCheques;
    }

    public String getBeneficiariesPaymentMode() {
        return beneficiariesPaymentMode;
    }

    public void setBeneficiariesPaymentMode(String beneficiariesPaymentMode) {
        this.beneficiariesPaymentMode = beneficiariesPaymentMode;
    }

    public String getFreqEffectiveDate() {
        return freqEffectiveDate;
    }

    public void setFreqEffectiveDate(String freqEffectiveDate) {
        this.freqEffectiveDate = freqEffectiveDate;
    }

    public String getArrearsPaymentMode() {
        return arrearsPaymentMode;
    }

    public void setArrearsPaymentMode(String arrearsPaymentMode) {
        this.arrearsPaymentMode = arrearsPaymentMode;
    }

    public String getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(String schemeId) {
        this.schemeId = schemeId;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public XiPensioner(Long id, String pensionerNo, String pensionFrequency, String name, String tax, String memberNo,
                       String pinNo, String idNo, String reason, String dob, String gender, String purchasePrice,
                       String guaranteedPeriod, String pensionStatus, String pensionStartDate, String pensionStopDate,
                       String payType, String monthlyPension, String totalPension, String partnerNumber, String alive,
                       String country, String commissionPaid, String accountName, String accountNumber, String pensionerType,
                       String dateOfCalculation, String certificateRecieved, String dateReceived, String dateLastPaid,
                       String dateLastEncashment, String unreturnedCheques, String beneficiariesPaymentMode, String freqEffectiveDate,
                       String arrearsPaymentMode, String schemeId, String town, String postalAddress, String branch,
                       String monthlyPension2, String cellPhone, String memberId, String email, String bankName) {
        super();
        this.id = id;
        this.pensionerNo = pensionerNo;
        this.pensionFrequency = pensionFrequency;
        this.name = name;
        this.email = email;
        this.tax = tax;
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.schemeId = schemeId;
        this.pinNo = pinNo;
        this.idNo = idNo;
        this.reason = reason;
        this.dob = dob;
        this.cellPhone = cellPhone;
        this.gender = gender;
        this.branch = branch;
        this.bankName = bankName;
        this.purchasePrice = purchasePrice;
        this.guaranteedPeriod = guaranteedPeriod;
        this.pensionStatus = pensionStatus;
        this.pensionStartDate = pensionStartDate;
        this.pensionStopDate = pensionStopDate;
        this.payType = payType;
        this.monthlyPension = monthlyPension;
        this.monthlyPension2 = monthlyPension2;
        this.totalPension = totalPension;
        this.partnerNumber = partnerNumber;
        this.alive = alive;
        this.town = town;
        this.postalAddress = postalAddress;
        this.country = country;
        this.commissionPaid = commissionPaid;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.pensionerType = pensionerType;
        this.dateOfCalculation = dateOfCalculation;
        this.certificateRecieved = certificateRecieved;
        this.dateReceived = dateReceived;
        this.dateLastPaid = dateLastPaid;
        this.dateLastEncashment = dateLastEncashment;
        this.unreturnedCheques = unreturnedCheques;
        this.beneficiariesPaymentMode = beneficiariesPaymentMode;
        this.freqEffectiveDate = freqEffectiveDate;
        this.arrearsPaymentMode = arrearsPaymentMode;
    }
}
