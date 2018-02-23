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
public class DBprojectionsDTO {

    private String dbDateOfExit;
    private String dbDateOfCalculation;
    private String dbReasonForExit;
    private String dbAgeAtExit;
    private String dbPensionableService;
    private BigDecimal dbPensionableSalary;

    private BigDecimal dbTargetPension;
    private BigDecimal dbAnnualPension;
    private BigDecimal dbGrossMonthlyPension;
    private BigDecimal dbTaxOnPension;
    private BigDecimal dbNetMonthlyPension;
    
     private BigDecimal dbCommutedLumpsum;
     private BigDecimal dbTaxFreeLumpsum;
     private BigDecimal dbTaxableAmount;
     private BigDecimal dbWithholdingTax;
     private BigDecimal dbMemberLiability;
     private BigDecimal dbLumpsumPayable;

    public String getDbDateOfExit() {
        return dbDateOfExit;
    }

    public void setDbDateOfExit(String dbDateOfExit) {
        this.dbDateOfExit = dbDateOfExit;
    }

    public String getDbDateOfCalculation() {
        return dbDateOfCalculation;
    }

    public void setDbDateOfCalculation(String dbDateOfCalculation) {
        this.dbDateOfCalculation = dbDateOfCalculation;
    }

    public String getDbReasonForExit() {
        return dbReasonForExit;
    }

    public void setDbReasonForExit(String dbReasonForExit) {
        this.dbReasonForExit = dbReasonForExit;
    }

    public String getDbAgeAtExit() {
        return dbAgeAtExit;
    }

    public void setDbAgeAtExit(String dbAgeAtExit) {
        this.dbAgeAtExit = dbAgeAtExit;
    }

    public String getDbPensionableService() {
        return dbPensionableService;
    }

    public void setDbPensionableService(String dbPensionableService) {
        this.dbPensionableService = dbPensionableService;
    }

    public BigDecimal getDbPensionableSalary() {
        return dbPensionableSalary;
    }

    public void setDbPensionableSalary(BigDecimal dbPensionableSalary) {
        this.dbPensionableSalary = dbPensionableSalary;
    }

    public BigDecimal getDbTargetPension() {
        return dbTargetPension;
    }

    public void setDbTargetPension(BigDecimal dbTargetPension) {
        this.dbTargetPension = dbTargetPension;
    }

    public BigDecimal getDbAnnualPension() {
        return dbAnnualPension;
    }

    public void setDbAnnualPension(BigDecimal dbAnnualPension) {
        this.dbAnnualPension = dbAnnualPension;
    }

    public BigDecimal getDbGrossMonthlyPension() {
        return dbGrossMonthlyPension;
    }

    public void setDbGrossMonthlyPension(BigDecimal dbGrossMonthlyPension) {
        this.dbGrossMonthlyPension = dbGrossMonthlyPension;
    }

    public BigDecimal getDbTaxOnPension() {
        return dbTaxOnPension;
    }

    public void setDbTaxOnPension(BigDecimal dbTaxOnPension) {
        this.dbTaxOnPension = dbTaxOnPension;
    }

    public BigDecimal getDbNetMonthlyPension() {
        return dbNetMonthlyPension;
    }

    public void setDbNetMonthlyPension(BigDecimal dbNetMonthlyPension) {
        this.dbNetMonthlyPension = dbNetMonthlyPension;
    }

    public BigDecimal getDbCommutedLumpsum() {
        return dbCommutedLumpsum;
    }

    public void setDbCommutedLumpsum(BigDecimal dbCommutedLumpsum) {
        this.dbCommutedLumpsum = dbCommutedLumpsum;
    }

    public BigDecimal getDbTaxFreeLumpsum() {
        return dbTaxFreeLumpsum;
    }

    public void setDbTaxFreeLumpsum(BigDecimal dbTaxFreeLumpsum) {
        this.dbTaxFreeLumpsum = dbTaxFreeLumpsum;
    }

    public BigDecimal getDbTaxableAmount() {
        return dbTaxableAmount;
    }

    public void setDbTaxableAmount(BigDecimal dbTaxableAmount) {
        this.dbTaxableAmount = dbTaxableAmount;
    }

    public BigDecimal getDbWithholdingTax() {
        return dbWithholdingTax;
    }

    public void setDbWithholdingTax(BigDecimal dbWithholdingTax) {
        this.dbWithholdingTax = dbWithholdingTax;
    }

    public BigDecimal getDbMemberLiability() {
        return dbMemberLiability;
    }

    public void setDbMemberLiability(BigDecimal dbMemberLiability) {
        this.dbMemberLiability = dbMemberLiability;
    }

    public BigDecimal getDbLumpsumPayable() {
        return dbLumpsumPayable;
    }

    public void setDbLumpsumPayable(BigDecimal dbLumpsumPayable) {
        this.dbLumpsumPayable = dbLumpsumPayable;
    }
     
     

}
