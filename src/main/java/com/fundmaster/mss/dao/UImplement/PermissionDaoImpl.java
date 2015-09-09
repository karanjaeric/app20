package com.fundmaster.mss.dao.UImplement;

import java.util.List;

import javax.persistence.EntityManager;

import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.dao.UInterface.PermissionDao;
import com.fundmaster.mss.model.Permission;

public class PermissionDaoImpl extends GenericModelDaoImpl<Permission> implements PermissionDao{

	private EntityManager em;

	public PermissionDaoImpl() {
		super();
		// TODO Auto-generated constructor stub

		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}

	public Permission findByProfile(String profile) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<Permission> logs = em.createQuery("SELECT p FROM Permission p WHERE profile=:profile").setParameter("profile", profile).getResultList();
		em.close();
		return logs.get(0);
	}

	public List<Permission> findAll() {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<Permission> entities = em.createQuery("SELECT p FROM Permission p").getResultList();
		em.close();
		return entities;
	}


	public Permission findById(Long id) {
		// TODO Auto-generated method stub
		Permission entity = em.find(Permission.class, id);
		em.close();
		return entity;
	}
	
}
