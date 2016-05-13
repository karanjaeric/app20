package com.fundmaster.mss.dao;

import javax.persistence.EntityManager;

import com.fundmaster.mss.model.Logo;

public class LogoDAO extends GenericDAOImpl<Logo, Long> {
	
	public LogoDAO(EntityManager entityManager)
	
    {
        super(Logo.class, entityManager);
        EntityManager em = entityManager;
    }

}
