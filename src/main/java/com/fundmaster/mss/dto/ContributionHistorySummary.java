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
public class ContributionHistorySummary {

    
    //summaary fields
    private BigDecimal eeSum;
    private BigDecimal erSum;
    private BigDecimal avcSum;
    private BigDecimal avcErSum;
    private BigDecimal salarySum;
    private BigDecimal totalSum;

    //getters and setters
    public BigDecimal getEeSum() {
        return eeSum;
    }

    public void setEeSum(BigDecimal eeSum) {
        this.eeSum = eeSum;
    }

    public BigDecimal getErSum() {
        return erSum;
    }

    public void setErSum(BigDecimal erSum) {
        this.erSum = erSum;
    }

    public BigDecimal getAvcSum() {
        return avcSum;
    }

    public void setAvcSum(BigDecimal avcSum) {
        this.avcSum = avcSum;
    }

    public BigDecimal getAvcErSum() {
        return avcErSum;
    }

    public void setAvcErSum(BigDecimal avcErSum) {
        this.avcErSum = avcErSum;
    }

    public BigDecimal getSalarySum() {
        return salarySum;
    }

    public void setSalarySum(BigDecimal salarySum) {
        this.salarySum = salarySum;
    }

    public BigDecimal getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(BigDecimal totalSum) {
        this.totalSum = totalSum;
    }

}
