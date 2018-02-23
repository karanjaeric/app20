/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fundmaster.mss.dto;

import java.math.BigDecimal;

/**
 *
 * @author ekaranja
 */
public class DCprojectionsDTO {
    //dto fields

    private String dateOfExit;
    private String dateOfCalculation;
    private String reasonForExit;
    private String ageAtExit;
    private String pensionableService;
    private BigDecimal totalBenefits;

    private BigDecimal pensionPurchasePrice;
    private BigDecimal annualPension;
    private BigDecimal grossMonthlyPension;
    private BigDecimal taxOnPension;
    private BigDecimal netMonthlyPension;

    private BigDecimal commutedLumpsum;
    private BigDecimal taxFreeLumpsum;
    private BigDecimal taxableAmount;
    private BigDecimal withholdingTax;
    private BigDecimal memberLiability;
    private BigDecimal lumpsumPayable;
    
    //getters and setters

    public String getDateOfExit() {
        return dateOfExit;
    }

    public void setDateOfExit(String dateOfExit) {
        this.dateOfExit = dateOfExit;
    }

    public String getDateOfCalculation() {
        return dateOfCalculation;
    }

    public void setDateOfCalculation(String dateOfCalculation) {
        this.dateOfCalculation = dateOfCalculation;
    }

    public String getReasonForExit() {
        return reasonForExit;
    }

    public void setReasonForExit(String reasonForExit) {
        this.reasonForExit = reasonForExit;
    }

    public String getAgeAtExit() {
        return ageAtExit;
    }

    public void setAgeAtExit(String ageAtExit) {
        this.ageAtExit = ageAtExit;
    }

    public String getPensionableService() {
        return pensionableService;
    }

    public void setPensionableService(String pensionableService) {
        this.pensionableService = pensionableService;
    }

    public BigDecimal getTotalBenefits() {
        return totalBenefits;
    }

    public void setTotalBenefits(BigDecimal totalBenefits) {
        this.totalBenefits = totalBenefits;
    }

    public BigDecimal getPensionPurchasePrice() {
        return pensionPurchasePrice;
    }

    public void setPensionPurchasePrice(BigDecimal pensionPurchasePrice) {
        this.pensionPurchasePrice = pensionPurchasePrice;
    }

    public BigDecimal getAnnualPension() {
        return annualPension;
    }

    public void setAnnualPension(BigDecimal annualPension) {
        this.annualPension = annualPension;
    }

    public BigDecimal getGrossMonthlyPension() {
        return grossMonthlyPension;
    }

    public void setGrossMonthlyPension(BigDecimal grossMonthlyPension) {
        this.grossMonthlyPension = grossMonthlyPension;
    }

    public BigDecimal getTaxOnPension() {
        return taxOnPension;
    }

    public void setTaxOnPension(BigDecimal taxOnPension) {
        this.taxOnPension = taxOnPension;
    }

    public BigDecimal getNetMonthlyPension() {
        return netMonthlyPension;
    }

    public void setNetMonthlyPension(BigDecimal netMonthlyPension) {
        this.netMonthlyPension = netMonthlyPension;
    }

    public BigDecimal getCommutedLumpsum() {
        return commutedLumpsum;
    }

    public void setCommutedLumpsum(BigDecimal commutedLumpsum) {
        this.commutedLumpsum = commutedLumpsum;
    }

    public BigDecimal getTaxFreeLumpsum() {
        return taxFreeLumpsum;
    }

    public void setTaxFreeLumpsum(BigDecimal taxFreeLumpsum) {
        this.taxFreeLumpsum = taxFreeLumpsum;
    }

    public BigDecimal getTaxableAmount() {
        return taxableAmount;
    }

    public void setTaxableAmount(BigDecimal taxableAmount) {
        this.taxableAmount = taxableAmount;
    }

    public BigDecimal getWithholdingTax() {
        return withholdingTax;
    }

    public void setWithholdingTax(BigDecimal withholdingTax) {
        this.withholdingTax = withholdingTax;
    }

    public BigDecimal getMemberLiability() {
        return memberLiability;
    }

    public void setMemberLiability(BigDecimal memberLiability) {
        this.memberLiability = memberLiability;
    }

    public BigDecimal getLumpsumPayable() {
        return lumpsumPayable;
    }

    public void setLumpsumPayable(BigDecimal lumpsumPayable) {
        this.lumpsumPayable = lumpsumPayable;
    }
    
    

}
