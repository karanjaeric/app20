package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.PasswordPolicy;

import javax.persistence.EntityManager;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class PasswordPolicyDAO extends GenericDAOImpl<PasswordPolicy, Long> {
    public PasswordPolicyDAO(EntityManager entityManager)
    {
        super(PasswordPolicy.class, entityManager);
        EntityManager em = entityManager;
    }
}
