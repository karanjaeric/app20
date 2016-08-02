package com.fundmaster.mss.beans.ejb;

import com.fundmaster.mss.model.Social;

import javax.ejb.Local;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface SocialEJB {

    Social edit(Social social);
    Social find();

}
