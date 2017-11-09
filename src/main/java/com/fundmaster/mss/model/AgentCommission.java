package com.fundmaster.mss.model;

import java.io.Serializable;

/**
 * Created by tony on 9/18/16.
 */
public class AgentCommission extends  GenericModel<AgentCommission> implements Serializable {

    private static final long serialVersionUID = 1L;

    public AgentCommission() {
    }

    private Long id;
    private String month;
    private String year;
    private String contr;
    private String commission;
    private String net;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getContr() {
        return contr;
    }

    public void setContr(String contr) {
        this.contr = contr;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public AgentCommission(Long id, String month, String year, String contr, String commission, String net) {
        super();
        this.id = id;
        this.month = month;
        this.year = year;
        this.contr = contr;
        this.commission = commission;
        this.net = net;

    }
}
