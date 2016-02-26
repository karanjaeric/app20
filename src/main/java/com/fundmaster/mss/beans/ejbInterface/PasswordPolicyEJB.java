package com.fundmaster.mss.beans.ejbInterface;

import com.fundmaster.mss.model.PasswordPolicy;

import javax.ejb.Local;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface PasswordPolicyEJB {

    PasswordPolicy edit(PasswordPolicy passwordPolicy);
    PasswordPolicy find();

}