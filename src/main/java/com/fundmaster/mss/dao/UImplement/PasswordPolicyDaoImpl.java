package com.fundmaster.mss.dao.UImplement;

import java.util.List;

import javax.persistence.EntityManager;

import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.model.PasswordPolicy;

public class PasswordPolicyDaoImpl extends GenericModelDaoImpl<PasswordPolicy> {


	private EntityManager em;

	public PasswordPolicyDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}

	public List<PasswordPolicy> findAll() {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<PasswordPolicy> entities = em.createQuery("SELECT p FROM PasswordPolicy p").getResultList();
		em.close();
		return entities;
	}
}
