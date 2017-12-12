package com.fundmaster.mss.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_account_recovery")
public class AccountRecovery extends GenericModel<AccountRecovery> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private	Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="accountRecoveryActive", nullable=false)
    private boolean accountRecoveryActive;

    @Column(name="accountRecoveryName", nullable=false)
    private String accountRecoveryName;


    public boolean isAccountRecoveryActive() {
        return accountRecoveryActive;
    }


    public void setAccountRecoveryActive(boolean accountRecoveryActive) {
        this.accountRecoveryActive = accountRecoveryActive;
    }

    public String getAccountRecoveryName() {
        return accountRecoveryName;
    }

    public void setAccountRecoveryName(String accountRecoveryName) {
        this.accountRecoveryName = accountRecoveryName;
    }


    public AccountRecovery(Long id, boolean accountRecoveryActive,String accountRecoveryName ){
        super();
        this.id = id;
        this.accountRecoveryActive =accountRecoveryActive;
        this.accountRecoveryName = accountRecoveryName;
    }

    public AccountRecovery(){
        super();
    }
}
