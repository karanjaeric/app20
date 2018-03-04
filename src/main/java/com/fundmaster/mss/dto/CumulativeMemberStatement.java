package com.fundmaster.mss.dto;

import java.math.BigDecimal;

/**
 *
 * @author ekaranja
 */
public class CumulativeMemberStatement {

    //opening Balance
    private BigDecimal openingEEReg;
    private BigDecimal openingEEUnreg;
    private BigDecimal openingERReg;
    private BigDecimal openingERUnreg;
    private BigDecimal openingAVCReg;
    private BigDecimal openingAVCUnreg;

    //Interest on opening Balances
    private BigDecimal intrOpeningEEReg;
    private BigDecimal intrOpeningEEUnreg;
    private BigDecimal intrOpeningERReg;
    private BigDecimal intrOpeningERUnreg;
    private BigDecimal intrOpeningAVCReg;
    private BigDecimal intrOpeningAVCUnreg;

    //Contributions
    private BigDecimal contrEEReg;
    private BigDecimal contrEEUnreg;
    private BigDecimal contrERReg;
    private BigDecimal contrERUnreg;
    private BigDecimal contrAVCReg;
    private BigDecimal contrAVCUnreg;

    //Interest On contributions
    private BigDecimal intrContrEEReg;
    private BigDecimal intrContrEEUnreg;
    private BigDecimal intrContrERReg;
    private BigDecimal intrContrERUnreg;
    private BigDecimal intrContrAVCReg;
    private BigDecimal intrContrAVCUnreg;

    //transfers
    private BigDecimal transferEEReg;
    private BigDecimal transferEEUnreg;

    private BigDecimal transferERReg;
    private BigDecimal transferERUnreg;

    private BigDecimal transferAVCReg;
    private BigDecimal transferAVCUnreg;

    //payments
    private BigDecimal payEEReg;
    private BigDecimal payEEUnreg;
    private BigDecimal payERReg;
    private BigDecimal payERUnreg;
    private BigDecimal payAVCReg;
    private BigDecimal payAVCUnreg;

    //totals
    private BigDecimal totalEEReg;
    private BigDecimal totalEEUnreg;
    private BigDecimal totalERReg;
    private BigDecimal totalERUnreg;
    private BigDecimal totalAVCReg;
    private BigDecimal totalAVCUnreg;
    
    //finally
    private BigDecimal grandTotal;
    private BigDecimal finalTotal;

    public BigDecimal getOpeningEEReg() {
        return openingEEReg;
    }

    public void setOpeningEEReg(BigDecimal openingEEReg) {
        this.openingEEReg = openingEEReg;
    }

    public BigDecimal getOpeningEEUnreg() {
        return openingEEUnreg;
    }

    public void setOpeningEEUnreg(BigDecimal openingEEUnreg) {
        this.openingEEUnreg = openingEEUnreg;
    }

    public BigDecimal getOpeningERReg() {
        return openingERReg;
    }

    public void setOpeningERReg(BigDecimal openingERReg) {
        this.openingERReg = openingERReg;
    }

    public BigDecimal getOpeningERUnreg() {
        return openingERUnreg;
    }

    public void setOpeningERUnreg(BigDecimal openingERUnreg) {
        this.openingERUnreg = openingERUnreg;
    }

    public BigDecimal getOpeningAVCReg() {
        return openingAVCReg;
    }

    public void setOpeningAVCReg(BigDecimal openingAVCReg) {
        this.openingAVCReg = openingAVCReg;
    }

    public BigDecimal getOpeningAVCUnreg() {
        return openingAVCUnreg;
    }

    public void setOpeningAVCUnreg(BigDecimal openingAVCUnreg) {
        this.openingAVCUnreg = openingAVCUnreg;
    }

    public BigDecimal getIntrOpeningEEReg() {
        return intrOpeningEEReg;
    }

    public void setIntrOpeningEEReg(BigDecimal intrOpeningEEReg) {
        this.intrOpeningEEReg = intrOpeningEEReg;
    }

    public BigDecimal getIntrOpeningEEUnreg() {
        return intrOpeningEEUnreg;
    }

    public void setIntrOpeningEEUnreg(BigDecimal intrOpeningEEUnreg) {
        this.intrOpeningEEUnreg = intrOpeningEEUnreg;
    }

    public BigDecimal getIntrOpeningERReg() {
        return intrOpeningERReg;
    }

    public void setIntrOpeningERReg(BigDecimal intrOpeningERReg) {
        this.intrOpeningERReg = intrOpeningERReg;
    }

    public BigDecimal getIntrOpeningERUnreg() {
        return intrOpeningERUnreg;
    }

    public void setIntrOpeningERUnreg(BigDecimal intrOpeningERUnreg) {
        this.intrOpeningERUnreg = intrOpeningERUnreg;
    }

    public BigDecimal getIntrOpeningAVCReg() {
        return intrOpeningAVCReg;
    }

    public void setIntrOpeningAVCReg(BigDecimal intrOpeningAVCReg) {
        this.intrOpeningAVCReg = intrOpeningAVCReg;
    }

    public BigDecimal getIntrOpeningAVCUnreg() {
        return intrOpeningAVCUnreg;
    }

    public void setIntrOpeningAVCUnreg(BigDecimal intrOpeningAVCUnreg) {
        this.intrOpeningAVCUnreg = intrOpeningAVCUnreg;
    }

    public BigDecimal getContrEEReg() {
        return contrEEReg;
    }

    public void setContrEEReg(BigDecimal contrEEReg) {
        this.contrEEReg = contrEEReg;
    }

    public BigDecimal getContrEEUnreg() {
        return contrEEUnreg;
    }

    public void setContrEEUnreg(BigDecimal contrEEUnreg) {
        this.contrEEUnreg = contrEEUnreg;
    }

    public BigDecimal getContrERReg() {
        return contrERReg;
    }

    public void setContrERReg(BigDecimal contrERReg) {
        this.contrERReg = contrERReg;
    }

    public BigDecimal getContrERUnreg() {
        return contrERUnreg;
    }

    public void setContrERUnreg(BigDecimal contrERUnreg) {
        this.contrERUnreg = contrERUnreg;
    }

    public BigDecimal getContrAVCReg() {
        return contrAVCReg;
    }

    public void setContrAVCReg(BigDecimal contrAVCReg) {
        this.contrAVCReg = contrAVCReg;
    }

    public BigDecimal getContrAVCUnreg() {
        return contrAVCUnreg;
    }

    public void setContrAVCUnreg(BigDecimal contrAVCUnreg) {
        this.contrAVCUnreg = contrAVCUnreg;
    }

    public BigDecimal getIntrContrEEReg() {
        return intrContrEEReg;
    }

    public void setIntrContrEEReg(BigDecimal intrContrEEReg) {
        this.intrContrEEReg = intrContrEEReg;
    }

    public BigDecimal getIntrContrEEUnreg() {
        return intrContrEEUnreg;
    }

    public void setIntrContrEEUnreg(BigDecimal intrContrEEUnreg) {
        this.intrContrEEUnreg = intrContrEEUnreg;
    }

    public BigDecimal getIntrContrERReg() {
        return intrContrERReg;
    }

    public void setIntrContrERReg(BigDecimal intrContrERReg) {
        this.intrContrERReg = intrContrERReg;
    }

    public BigDecimal getIntrContrERUnreg() {
        return intrContrERUnreg;
    }

    public void setIntrContrERUnreg(BigDecimal intrContrERUnreg) {
        this.intrContrERUnreg = intrContrERUnreg;
    }

    public BigDecimal getIntrContrAVCReg() {
        return intrContrAVCReg;
    }

    public void setIntrContrAVCReg(BigDecimal intrContrAVCReg) {
        this.intrContrAVCReg = intrContrAVCReg;
    }

    public BigDecimal getIntrContrAVCUnreg() {
        return intrContrAVCUnreg;
    }

    public void setIntrContrAVCUnreg(BigDecimal intrContrAVCUnreg) {
        this.intrContrAVCUnreg = intrContrAVCUnreg;
    }

    public BigDecimal getTransferEEReg() {
        return transferEEReg;
    }

    public void setTransferEEReg(BigDecimal transferEEReg) {
        this.transferEEReg = transferEEReg;
    }

    public BigDecimal getTransferEEUnreg() {
        return transferEEUnreg;
    }

    public void setTransferEEUnreg(BigDecimal transferEEUnreg) {
        this.transferEEUnreg = transferEEUnreg;
    }

    public BigDecimal getTransferERReg() {
        return transferERReg;
    }

    public void setTransferERReg(BigDecimal transferERReg) {
        this.transferERReg = transferERReg;
    }

    public BigDecimal getTransferERUnreg() {
        return transferERUnreg;
    }

    public void setTransferERUnreg(BigDecimal transferERUnreg) {
        this.transferERUnreg = transferERUnreg;
    }

    public BigDecimal getTransferAVCReg() {
        return transferAVCReg;
    }

    public void setTransferAVCReg(BigDecimal transferAVCReg) {
        this.transferAVCReg = transferAVCReg;
    }

    public BigDecimal getTransferAVCUnreg() {
        return transferAVCUnreg;
    }

    public void setTransferAVCUnreg(BigDecimal transferAVCUnreg) {
        this.transferAVCUnreg = transferAVCUnreg;
    }

    public BigDecimal getPayEEReg() {
        return payEEReg;
    }

    public void setPayEEReg(BigDecimal payEEReg) {
        this.payEEReg = payEEReg;
    }

    public BigDecimal getPayEEUnreg() {
        return payEEUnreg;
    }

    public void setPayEEUnreg(BigDecimal payEEUnreg) {
        this.payEEUnreg = payEEUnreg;
    }

    public BigDecimal getPayERReg() {
        return payERReg;
    }

    public void setPayERReg(BigDecimal payERReg) {
        this.payERReg = payERReg;
    }

    public BigDecimal getPayERUnreg() {
        return payERUnreg;
    }

    public void setPayERUnreg(BigDecimal payERUnreg) {
        this.payERUnreg = payERUnreg;
    }

    public BigDecimal getPayAVCReg() {
        return payAVCReg;
    }

    public void setPayAVCReg(BigDecimal payAVCReg) {
        this.payAVCReg = payAVCReg;
    }

    public BigDecimal getPayAVCUnreg() {
        return payAVCUnreg;
    }

    public void setPayAVCUnreg(BigDecimal payAVCUnreg) {
        this.payAVCUnreg = payAVCUnreg;
    }

    public BigDecimal getTotalEEReg() {
        return totalEEReg;
    }

    public void setTotalEEReg(BigDecimal totalEEReg) {
        this.totalEEReg = totalEEReg;
    }

    public BigDecimal getTotalEEUnreg() {
        return totalEEUnreg;
    }

    public void setTotalEEUnreg(BigDecimal totalEEUnreg) {
        this.totalEEUnreg = totalEEUnreg;
    }

    public BigDecimal getTotalERReg() {
        return totalERReg;
    }

    public void setTotalERReg(BigDecimal totalERReg) {
        this.totalERReg = totalERReg;
    }

    public BigDecimal getTotalERUnreg() {
        return totalERUnreg;
    }

    public void setTotalERUnreg(BigDecimal totalERUnreg) {
        this.totalERUnreg = totalERUnreg;
    }

    public BigDecimal getTotalAVCReg() {
        return totalAVCReg;
    }

    public void setTotalAVCReg(BigDecimal totalAVCReg) {
        this.totalAVCReg = totalAVCReg;
    }

    public BigDecimal getTotalAVCUnreg() {
        return totalAVCUnreg;
    }

    public void setTotalAVCUnreg(BigDecimal totalAVCUnreg) {
        this.totalAVCUnreg = totalAVCUnreg;
    }

    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    }

    public BigDecimal getFinalTotal() {
        return finalTotal;
    }

    public void setFinalTotal(BigDecimal finalTotal) {
        this.finalTotal = finalTotal;
    }
    
    
   

}
