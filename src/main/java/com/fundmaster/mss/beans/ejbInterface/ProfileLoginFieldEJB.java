package com.fundmaster.mss.beans.ejbInterface;

import com.fundmaster.mss.model.ProfileLoginField;

import javax.ejb.Local;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface ProfileLoginFieldEJB {

    ProfileLoginField edit(ProfileLoginField profileLoginField);
    ProfileLoginField findByProfile(String profile);

}
