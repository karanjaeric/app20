package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.Theme;

import javax.ejb.Local;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface ThemeBeanI {
    Theme find();
    Theme edit(Theme theme);
    Theme findById(long id);
}
