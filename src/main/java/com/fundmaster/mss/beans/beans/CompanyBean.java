package com.fundmaster.mss.beans.beans;

import com.fundmaster.mss.beans.ejb.CompanyEJB;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.CompanyDAO;
import com.fundmaster.mss.model.Company;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
@Stateless
public class CompanyBean implements CompanyEJB {

    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;
    @Override
    public Company edit(Company company) {
        CompanyDAO dao = new CompanyDAO(entityManager);
        return dao.merge(company);
    }

    @Override
    public Company find() {
        CompanyDAO dao = new CompanyDAO(entityManager);
        return dao.find();
    }
}
