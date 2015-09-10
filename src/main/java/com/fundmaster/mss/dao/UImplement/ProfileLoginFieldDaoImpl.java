package com.fundmaster.mss.dao.UImplement;

import java.util.List;

import javax.persistence.EntityManager;

import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.dao.UInterface.ProfileLoginFieldDao;
import com.fundmaster.mss.model.ProfileLoginField;

public class ProfileLoginFieldDaoImpl extends GenericModelDaoImpl<ProfileLoginField> implements ProfileLoginFieldDao{
	private EntityManager em;

	public ProfileLoginFieldDaoImpl() {
		super();
		// TODO Auto-generated constructor stub

		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}

	public ProfileLoginField findByProfile(String profile) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<ProfileLoginField> logs = em.createQuery("SELECT p FROM ProfileLoginField p WHERE p.profile=:profile").setParameter("profile", profile).setMaxResults(5).getResultList();
		em.close();
		return logs.get(0);
	}

	public List<ProfileLoginField> findAll() {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<ProfileLoginField> entities = em.createQuery("SELECT p FROM ProfileLoginField p").getResultList();
		em.close();
		return entities;
	}


	public ProfileLoginField findById(Long id) {
		// TODO Auto-generated method stub
		ProfileLoginField entity = em.find(ProfileLoginField.class, id);
		em.close();
		return entity;
	}
}
