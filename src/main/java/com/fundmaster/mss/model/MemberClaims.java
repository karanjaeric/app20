package com.fundmaster.mss.model;

import java.io.Serializable;

/**
 * Created by tony on 11/4/16.
 */
public class MemberClaims extends GenericModel<MemberClaims> implements Serializable {

    private static final long serialVersionUID = 1L;

    public MemberClaims() {

    }

    private Long memberNo;
    private Long membershipNo;
    private Long benefitPaymentId;
    private Long memberId;
    private String netPayment;
    private String currentStatus;
    private String reasonForExit;
    private String dateOfExit;
    private String processed;
    private String servicePeriod;

    public Long getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Long memberNo) {
        this.memberNo = memberNo;
    }

    public Long getMembershipNo() {
        return membershipNo;
    }

    public void setMembershipNo(Long membershipNo) {
        this.membershipNo = membershipNo;
    }

    public Long getBenefitPaymentId() {
        return benefitPaymentId;
    }

    public void setBenefitPaymentId(Long benefitPaymentId) {
        this.benefitPaymentId = benefitPaymentId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getNetPayment() {
        return netPayment;
    }

    public void setNetPayment(String netPayment) {
        this.netPayment = netPayment;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getReasonForExit() {
        return reasonForExit;
    }

    public void setReasonForExit(String reasonForExit) {
        this.reasonForExit = reasonForExit;
    }

    public String getDateOfExit() {
        return dateOfExit;
    }

    public void setDateOfExit(String dateOfExit) {
        this.dateOfExit = dateOfExit;
    }

    public String getProcessed() {
        return processed;
    }

    public void setProcessed(String processed) {
        this.processed = processed;
    }

    public String getServicePeriod() {
        return servicePeriod;
    }

    public void setServicePeriod(String servicePeriod) {
        this.servicePeriod = servicePeriod;
    }

    public MemberClaims(Long memberNo, Long membershipNo, Long benefitPaymentId, Long memberId, String netPayment, String currentStatus,
                        String reasonForExit, String dateOfExit, String processed, String servicePeriod) {

        super();
        this.memberNo = memberNo;
        this.membershipNo = membershipNo;
        this.benefitPaymentId = benefitPaymentId;
        this.memberId = memberId;
        this.netPayment = netPayment;
        this.currentStatus = currentStatus;
        this.reasonForExit = reasonForExit;
        this.dateOfExit = dateOfExit;
        this.processed = processed;
        this.servicePeriod = servicePeriod;
    }

}

