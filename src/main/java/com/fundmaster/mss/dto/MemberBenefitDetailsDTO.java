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
public class MemberBenefitDetailsDTO {
    
    //dto fielde
    private BigDecimal employee;
    private BigDecimal employer;
    private BigDecimal avc;
    private BigDecimal interest;
    private BigDecimal cumulativeInterestToDate;
    private BigDecimal grandTotal;

    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    }
    
    
    //getters and setters

    public BigDecimal getEmployee() {
        return employee;
    }

    public void setEmployee(BigDecimal employee) {
        this.employee = employee;
    }

    public BigDecimal getEmployer() {
        return employer;
    }

    public void setEmployer(BigDecimal employer) {
        this.employer = employer;
    }

    public BigDecimal getAvc() {
        return avc;
    }

    public void setAvc(BigDecimal avc) {
        this.avc = avc;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getCumulativeInterestToDate() {
        return cumulativeInterestToDate;
    }

    public void setCumulativeInterestToDate(BigDecimal cumulativeInterestToDate) {
        this.cumulativeInterestToDate = cumulativeInterestToDate;
    }
    
   
    
}
