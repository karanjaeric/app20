package com.fundmaster.mss.beans.ejbInterface;

import com.fundmaster.mss.model.Theme;

import javax.ejb.Local;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface ThemeEJB {
    Theme find();
    Theme edit(Theme theme);
    Theme findById(long id);
}
