package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.Banner;

import javax.persistence.EntityManager;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class BannerDAO extends GenericDAOImpl<Banner, Long> {
    public BannerDAO(EntityManager entityManager)
    {
        super(Banner.class, entityManager);
        EntityManager em = entityManager;
    }

}
