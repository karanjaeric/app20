package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.PensionerMenu;

import javax.ejb.Local;

/**
 * Created by tony on 3/29/17.
 */

@Local
public interface PensionerMenuBeanI {

    PensionerMenu find();
    PensionerMenu edit(PensionerMenu pensionerMenu);
}
