package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.Menu;

import javax.ejb.Local;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface MenuBeanI {

    Menu find();
    Menu edit(Menu menu);
}
