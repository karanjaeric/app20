package com.fundmaster.mss.beans.ejb;

import com.fundmaster.mss.model.MemberPermission;

import javax.ejb.Local;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface MemberPermissionEJB {

    MemberPermission edit(MemberPermission memberPermission);
    MemberPermission find();

}
