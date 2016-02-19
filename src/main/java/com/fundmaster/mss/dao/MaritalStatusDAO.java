package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.MaritalStatus;

import javax.persistence.EntityManager;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class MaritalStatusDAO extends GenericDAOImpl<MaritalStatus, Long> {
    public MaritalStatusDAO(EntityManager entityManager)
    {
        super(MaritalStatus.class, entityManager);
        EntityManager em = entityManager;
    }
}
