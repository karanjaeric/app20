package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.Permission;

import javax.ejb.Local;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface PermissionBeanI {

    Permission findByProfile(String profile);
    Permission edit(Permission permission);

}
