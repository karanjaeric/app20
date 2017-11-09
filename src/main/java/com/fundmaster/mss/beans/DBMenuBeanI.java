package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.DBMenu;

import javax.ejb.Local;

/**
 * Created by tony on 2/17/17.
 */

@Local
public interface DBMenuBeanI {

    DBMenu find();
    DBMenu edit(DBMenu menu);
}
