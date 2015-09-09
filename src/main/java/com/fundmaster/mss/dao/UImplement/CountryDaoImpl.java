package com.fundmaster.mss.dao.UImplement;

import java.util.List;

import javax.persistence.EntityManager;

import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.dao.UInterface.CountryDao;
import com.fundmaster.mss.model.Country;

public class CountryDaoImpl extends GenericModelDaoImpl<Country> implements CountryDao {


	private EntityManager em;

	public CountryDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}

	public List<Country> findAll() {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<Country> entities = em.createQuery("SELECT c FROM Country c").getResultList();
		em.close();
		return entities;
	}


	public Country findById(Long id) {
		// TODO Auto-generated method stub
		Country entity = em.find(Country.class, id);
		em.close();
		return entity;
	}
}
