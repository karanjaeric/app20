package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.Company;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class CompanyDAO extends GenericDAOImpl<Company, Long> {
    public CompanyDAO(EntityManager entityManager)
    {
        super(Company.class, entityManager);
    }

    public Company find()
    {
        List<Company> companyList = findAll();
        if(companyList != null) {
            return companyList.size() > 0 ? companyList.get(0) : null;
        }
        return null;
    }
}
