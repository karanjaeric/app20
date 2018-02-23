package com.fundmaster.mss.dto;

import java.math.BigDecimal;

/**
 *
 * @author ekaranja
 */
public class ContributionsHistoryDTO {

    private String datePaid;
    private String month;
    private String year;
    private BigDecimal ee;
    private BigDecimal er;
    private BigDecimal avc;
    private BigDecimal avcer;
    private BigDecimal salary;
    private BigDecimal total;
    private String type;
    private String regUnreg;

    public String getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(String datePaid) {
        this.datePaid = datePaid;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public BigDecimal getEe() {
        return ee;
    }

    public void setEe(BigDecimal ee) {
        this.ee = ee;
    }

    public BigDecimal getEr() {
        return er;
    }

    public void setEr(BigDecimal er) {
        this.er = er;
    }

    public BigDecimal getAvc() {
        return avc;
    }

    public void setAvc(BigDecimal avc) {
        this.avc = avc;
    }

    public BigDecimal getAvcer() {
        return avcer;
    }

    public void setAvcer(BigDecimal avcer) {
        this.avcer = avcer;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegUnreg() {
        return regUnreg;
    }

    public void setRegUnreg(String regUnreg) {
        this.regUnreg = regUnreg;
    }
    
    
    
    
}
