package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.Country;
import com.fundmaster.mss.model.Member;

import java.util.List;

import javax.persistence.EntityManager;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class CountryDAO extends GenericDAOImpl<Country, Long> {
    public CountryDAO(EntityManager entityManager)
    {
        super(Country.class, entityManager);
        EntityManager em = entityManager;
    }
    
    
}
