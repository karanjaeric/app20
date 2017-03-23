package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.MemberDashboardItems;

import javax.ejb.Local;

/**
 * Created by tony on 3/23/17.
 */

@Local
public interface MemberDashboardBeanI {

    MemberDashboardItems find();
    MemberDashboardItems edit(MemberDashboardItems memberDashboardItems);
}
