package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.MemberMenu;

import javax.ejb.Local;

/**
 * Created by tony on 3/13/17.
 */

@Local
public interface MemberMenuBeanI {
    MemberMenu find();
    MemberMenu edit(MemberMenu memberMenu);
}
