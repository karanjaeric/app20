package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.Logo;

import javax.persistence.EntityManager;

public class LogoDAO extends GenericDAOImpl<Logo, Long> {
	
	public LogoDAO(EntityManager entityManager)
	
    {
        super(Logo.class, entityManager);
    }

}
