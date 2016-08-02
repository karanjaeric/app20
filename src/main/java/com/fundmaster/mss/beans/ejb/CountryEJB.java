package com.fundmaster.mss.beans.ejb;

import com.fundmaster.mss.model.Country;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface CountryEJB {

    Country add(Country country);
    Country edit(Country country);
    Country findById(long id);
    List<Country> find();
    boolean delete(Country country);

}
