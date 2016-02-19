package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.Gender;

import javax.persistence.EntityManager;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class GenderDAO extends GenericDAOImpl<Gender, Long> {
    public GenderDAO(EntityManager entityManager)
    {
        super(Gender.class, entityManager);
        EntityManager em = entityManager;
    }
}
