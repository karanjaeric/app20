package com.fundmaster.mss.model;

import java.io.Serializable;

public class ClientOrdinal extends GenericModel<ClientOrdinal> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ClientOrdinal() {
        // TODO Auto-generated constructor stub
    }

    private Long id;
    private String abbreviation;
    private String fullname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public ClientOrdinal(Long id, String abbreviation, String fullname) {
        super();
        this.id = id;
        this.fullname = fullname;
        this.abbreviation = abbreviation;
    }
}
