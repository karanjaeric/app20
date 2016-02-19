package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.ProfileName;

import javax.persistence.EntityManager;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class ProfileNameDAO extends GenericDAOImpl<ProfileName, Long> {
    public ProfileNameDAO(EntityManager entityManager)
    {
        super(ProfileName.class, entityManager);
        EntityManager em = entityManager;
    }
}
