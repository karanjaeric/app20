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
public class BalanceHistoryDTO {
    private BigDecimal eeClose;
    private BigDecimal erClose;
    private String asAt;
    private BigDecimal eeBal;
    private BigDecimal eeContr;
    private BigDecimal eeIntr;
    private BigDecimal erBal;
    private BigDecimal erContr;
    private BigDecimal erIntr;
    private BigDecimal grandTotal;

    public BigDecimal getEeClose() {
        return eeClose;
    }

    public void setEeClose(BigDecimal eeClose) {
        this.eeClose = eeClose;
    }

    public BigDecimal getErClose() {
        return erClose;
    }

    public void setErClose(BigDecimal erClose) {
        this.erClose = erClose;
    }

    public String getAsAt() {
        return asAt;
    }

    public void setAsAt(String asAt) {
        this.asAt = asAt;
    }

    public BigDecimal getEeBal() {
        return eeBal;
    }

    public void setEeBal(BigDecimal eeBal) {
        this.eeBal = eeBal;
    }

    public BigDecimal getEeContr() {
        return eeContr;
    }

    public void setEeContr(BigDecimal eeContr) {
        this.eeContr = eeContr;
    }

    public BigDecimal getEeIntr() {
        return eeIntr;
    }

    public void setEeIntr(BigDecimal eeIntr) {
        this.eeIntr = eeIntr;
    }

    public BigDecimal getErBal() {
        return erBal;
    }

    public void setErBal(BigDecimal erBal) {
        this.erBal = erBal;
    }

    public BigDecimal getErContr() {
        return erContr;
    }

    public void setErContr(BigDecimal erContr) {
        this.erContr = erContr;
    }

    public BigDecimal getErIntr() {
        return erIntr;
    }

    public void setErIntr(BigDecimal erIntr) {
        this.erIntr = erIntr;
    }

    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    }
    
    
   
    
}
