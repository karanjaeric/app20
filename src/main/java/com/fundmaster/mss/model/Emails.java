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

    @Column(name="sendWhatifEmail", nullable=false)
    private boolean sendWhatifEmail;

    @Column(name="defaultEmailActive", nullable=false)
    private boolean defaultEmailActive;

    @Column(name="marketingEmailActive", nullable=false)
    private boolean marketingEmailActive;

    @Column(name="supportEmailActive", nullable=false)
    private boolean supportEmailActive;

    public Emails() {

    }

    public Emails(Long id, String defaultEmail,String marketingEmail, String supportEmail, boolean sendWhatifEmail, boolean defaultEmailActive,
    boolean marketingEmailActive, boolean supportEmailActive) {
        super();
        this.id = id;
        this.defaultEmail = defaultEmail;
        this.defaultEmailActive =defaultEmailActive;
        this.marketingEmailActive = marketingEmailActive;
        this.supportEmailActive = supportEmailActive;
        this.marketingEmail = marketingEmail;
        this.supportEmail = supportEmail;
        this.sendWhatifEmail = sendWhatifEmail;
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

    public boolean isSendWhatifEmail() {
        return sendWhatifEmail;
    }

    public void setSendWhatifEmail(boolean sendWhatifEmail) {
        this.sendWhatifEmail = sendWhatifEmail;
    }

    public boolean isDefaultEmailActive() {
        return defaultEmailActive;
    }

    public void setDefaultEmailActive(boolean defaultEmailActive) {
        this.defaultEmailActive = defaultEmailActive;
    }

    public boolean isMarketingEmailActive() {
        return marketingEmailActive;
    }

    public void setMarketingEmailActive(boolean marketingEmailActive) {
        this.marketingEmailActive = marketingEmailActive;
    }

    public boolean isSupportEmailActive() {
        return supportEmailActive;
    }

    public void setSupportEmailActive(boolean supportEmailActive) {
        this.supportEmailActive = supportEmailActive;
    }
}
