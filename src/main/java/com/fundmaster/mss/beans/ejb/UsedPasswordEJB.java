package com.fundmaster.mss.beans.ejb;

import com.fundmaster.mss.model.UsedPassword;

import javax.ejb.Local;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface UsedPasswordEJB {

    boolean isUsed(String password);
    UsedPassword add(UsedPassword usedPassword);

}
