package com.fundmaster.mss.beans.ejb;

import com.fundmaster.mss.model.Setting;

import javax.ejb.Local;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface SettingEJB {

    Setting find();
    Setting edit(Setting setting);

}
