package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.Social;

import javax.persistence.EntityManager;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class SocialDAO extends GenericDAOImpl<Social, Long> {
    public SocialDAO(EntityManager entityManager)
    {
        super(Social.class, entityManager);
    }
}
