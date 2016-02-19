package com.fundmaster.mss.beans.ejbInterface;

import com.fundmaster.mss.model.Permission;

import javax.ejb.Local;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface PermissionEJB {

    Permission findByProfile(String profile);
    Permission edit(Permission permission);

}
