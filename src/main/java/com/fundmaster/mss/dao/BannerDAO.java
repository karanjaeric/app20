package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.ImageBanner;

import javax.persistence.EntityManager;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class BannerDAO extends GenericDAOImpl<ImageBanner, Long> {
    public BannerDAO(EntityManager entityManager)
    {
        super(ImageBanner.class, entityManager);
    }

}
