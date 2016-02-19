package com.fundmaster.mss.beans.ejbInterface;

import com.fundmaster.mss.model.Company;

import javax.ejb.Local;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface CompanyEJB {

    Company edit(Company company);
    Company find();

}
