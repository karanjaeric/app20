package com.fundmaster.mss.beans;

import com.fundmaster.mss.beans.CountryBeanI;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.CountryDAO;
import com.fundmaster.mss.model.Country;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Stateless
@Local
public class CountryBean implements CountryBeanI {


    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public Country add(Country country) {
        CountryDAO dao = new CountryDAO(entityManager);
        return dao.save(country);
    }

    @Override
    public Country findById(long id) {
        CountryDAO dao = new CountryDAO(entityManager);
        return dao.findById(id);
    }

    @Override
    public Country edit(Country country) {
        CountryDAO dao = new CountryDAO(entityManager);
        return dao.merge(country);
    }

    @Override
    public List<Country> find() {
        CountryDAO dao = new CountryDAO(entityManager);
        return dao.findAll();
    }

    @Override
    public boolean delete(Country country) {
        CountryDAO dao = new CountryDAO(entityManager);
        return dao.remove(country);
    }
}
