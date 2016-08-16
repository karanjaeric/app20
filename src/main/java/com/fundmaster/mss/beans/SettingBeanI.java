package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.Setting;

import javax.ejb.Local;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface SettingBeanI {

    Setting find();
    Setting edit(Setting setting);

}
