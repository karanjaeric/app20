package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.Company;

import javax.ejb.Local;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface CompanyBeanI {

    Company edit(Company company);
    Company find();

}
