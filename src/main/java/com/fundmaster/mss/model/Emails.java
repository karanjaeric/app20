package com.fundmaster.mss.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by tony on 11/8/16.
 */

@Entity
@Table(name = "tbl_emails")

public class Emails extends GenericModel<Emails> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "defaultEmail", nullable = false)
    private String defaultEmail;

    @Column (name = "marketingEmail", nullable = false)
    private String marketingEmail;

    @Column (name = "supportEmail", nullable = false)
    private String supportEmail;

    public Emails() {

    }

    public Emails(Long id, String defaultEmail,String marketingEmail, String supportEmail) {
        super();
        this.id = id;
        this.defaultEmail = defaultEmail;
        this.marketingEmail = marketingEmail;
        this.supportEmail = supportEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDefaultEmail() {
        return defaultEmail;
    }

    public void setDefaultEmail(String defaultEmail) {
        this.defaultEmail = defaultEmail;
    }

    public String getMarketingEmail() {
        return marketingEmail;
    }

    public void setMarketingEmail(String marketingEmail) {
        this.marketingEmail = marketingEmail;
    }

    public String getSupportEmail() {
        return supportEmail;
    }

    public void setSupportEmail(String supportEmail) {
        this.supportEmail = supportEmail;
    }
}
