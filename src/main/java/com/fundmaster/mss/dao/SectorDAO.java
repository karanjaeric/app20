package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.Sector;

import javax.persistence.EntityManager;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class SectorDAO extends GenericDAOImpl<Sector, Long> {
    public SectorDAO(EntityManager entityManager)
    {
        super(Sector.class, entityManager);
    }
}
