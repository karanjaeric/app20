package com.fundmaster.mss.beans.ejb;

import com.fundmaster.mss.model.ProfileLoginField;

import javax.ejb.Local;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface ProfileLoginFieldEJB {

    ProfileLoginField edit(ProfileLoginField profileLoginField);
    String findByProfile(String profile);

}
