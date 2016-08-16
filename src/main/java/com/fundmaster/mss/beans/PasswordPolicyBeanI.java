package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.PasswordPolicy;

import javax.ejb.Local;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface PasswordPolicyBeanI {

    PasswordPolicy edit(PasswordPolicy passwordPolicy);
    PasswordPolicy find();

}
