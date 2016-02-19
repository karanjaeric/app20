package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.Scheme;

import javax.persistence.EntityManager;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class SchemeDAO extends GenericDAOImpl<Scheme, Long> {
    public SchemeDAO(EntityManager entityManager)
    {
        super(Scheme.class, entityManager);
        EntityManager em = entityManager;
    }

}
