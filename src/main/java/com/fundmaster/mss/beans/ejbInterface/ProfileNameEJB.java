package com.fundmaster.mss.beans.ejbInterface;

import com.fundmaster.mss.model.ProfileName;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface ProfileNameEJB {

    ProfileName edit(ProfileName profileName);
    List<ProfileName> find();

}
