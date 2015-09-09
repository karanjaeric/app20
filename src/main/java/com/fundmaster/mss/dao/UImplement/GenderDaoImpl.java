package com.fundmaster.mss.dao.UImplement;

import java.util.List;

import javax.persistence.EntityManager;

import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.dao.UInterface.GenderDao;
import com.fundmaster.mss.model.Gender;

public class GenderDaoImpl extends GenericModelDaoImpl<Gender> implements GenderDao {



	private EntityManager em;

	public GenderDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}

	public List<Gender> findAll() {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<Gender> entities = em.createQuery("SELECT g FROM Gender g").getResultList();
		em.close();
		return entities;
	}

	public Gender findById(Long id) {
		// TODO Auto-generated method stub
		Gender entity = em.find(Gender.class, id);
		em.close();
		return entity;
	}
}
