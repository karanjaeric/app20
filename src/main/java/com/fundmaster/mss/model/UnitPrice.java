package com.fundmaster.mss.model;

import java.io.Serializable;

public class UnitPrice extends GenericModel<InterestRate> implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public UnitPrice() {
        // TODO Auto-generated constructor stub
    }

    private Long id;
    private String priceDate;
    private String price;
    private String contributions;
    private String annualChange;
    private String unitsBought;
    private String counter;
    private String payments;
    private String status;
    private String fundValue;
    private String units;
    private String percentChange;
    private String profile;
    private String change;
    private String prevPrice;
    private String exception;
    private String ap;
    private String investment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(String priceDate) {
        this.priceDate = priceDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getContributions() {
        return contributions;
    }

    public void setContributions(String contributions) {
        this.contributions = contributions;
    }

    public String getAnnualChange() {
        return annualChange;
    }

    public void setAnnualChange(String annualChange) {
        this.annualChange = annualChange;
    }

    public String getUnitsBought() {
        return unitsBought;
    }

    public void setUnitsBought(String unitsBought) {
        this.unitsBought = unitsBought;
    }

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

    public String getPayments() {
        return payments;
    }

    public void setPayments(String payments) {
        this.payments = payments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFundValue() {
        return fundValue;
    }

    public void setFundValue(String fundValue) {
        this.fundValue = fundValue;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(String percentChange) {
        this.percentChange = percentChange;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getPrevPrice() {
        return prevPrice;
    }

    public void setPrevPrice(String prevPrice) {
        this.prevPrice = prevPrice;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public String getInvestment() {
        return investment;
    }

    public void setInvestment(String investment) {
        this.investment = investment;
    }

    public UnitPrice(Long id, String priceDate, String price, String contributions, String annualChange, String unitsBought, String counter, String payments, String status, String fundValue, String units, String percentChange, String profile, String change, String prevPrice, String exception, String ap, String investment) {
        this.id = id;
        this.priceDate = priceDate;
        this.price = price;
        this.contributions = contributions;
        this.annualChange = annualChange;
        this.unitsBought = unitsBought;
        this.counter = counter;
        this.payments = payments;
        this.status = status;
        this.fundValue = fundValue;
        this.units = units;
        this.percentChange = percentChange;
        this.profile = profile;
        this.change = change;
        this.prevPrice = prevPrice;
        this.exception = exception;
        this.ap = ap;
        this.investment = investment;
    }
}
