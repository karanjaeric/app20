package com.fundmaster.mss.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by tony on 3/15/17.
 */
public class BalancesHistory  extends GenericModel<BalancesHistory> implements Serializable {

    private static final long serialVersionUID = 1L;

    public BalancesHistory() {
        // TODO Auto-generated constructor stub
    }

    private Long id;
    private BigDecimal member_no;
    private String name;
    private BigDecimal ee_bal;
    private BigDecimal ee_contr;
    private BigDecimal ee_intr;
    private BigDecimal er_bal;
    private BigDecimal er_contr;
    private BigDecimal er_intr;
    private Date as_at;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMember_no() {
        return member_no;
    }

    public void setMember_no(BigDecimal member_no) {
        this.member_no = member_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getEe_bal() {
        return ee_bal;
    }

    public void setEe_bal(BigDecimal ee_bal) {
        this.ee_bal = ee_bal;
    }

    public BigDecimal getEe_contr() {
        return ee_contr;
    }

    public void setEe_contr(BigDecimal ee_contr) {
        this.ee_contr = ee_contr;
    }

    public BigDecimal getEe_intr() {
        return ee_intr;
    }

    public void setEe_intr(BigDecimal ee_intr) {
        this.ee_intr = ee_intr;
    }

    public BigDecimal getEr_bal() {
        return er_bal;
    }

    public void setEr_bal(BigDecimal er_bal) {
        this.er_bal = er_bal;
    }

    public BigDecimal getEr_contr() {
        return er_contr;
    }

    public void setEr_contr(BigDecimal er_contr) {
        this.er_contr = er_contr;
    }

    public BigDecimal getEr_intr() {
        return er_intr;
    }

    public void setEr_intr(BigDecimal er_intr) {
        this.er_intr = er_intr;
    }

    public Date getAs_at() {
        return as_at;
    }

    public void setAs_at(Date as_at) {
        this.as_at = as_at;
    }

    public BalancesHistory(Long id, BigDecimal member_no, String name, BigDecimal ee_bal, BigDecimal ee_contr,
                           BigDecimal ee_intr, BigDecimal er_bal, BigDecimal er_contr, BigDecimal er_intr, Date as_at) {
        super();
        this.id = id;
        this.member_no = member_no;
        this.name = name;
        this.ee_bal = ee_bal;
        this.ee_contr = ee_contr;
        this.ee_intr = ee_intr;
        this.er_bal = er_bal;
        this.er_contr = er_contr;
        this.er_intr = er_intr;
        this.as_at = as_at;
    }
}
