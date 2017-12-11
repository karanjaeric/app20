package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.AccountRecovery;

import javax.ejb.Local;

@Local
public interface AccountRecoveryBeanI {

    AccountRecovery find();

    AccountRecovery edit(AccountRecovery accountRecovery);
}
