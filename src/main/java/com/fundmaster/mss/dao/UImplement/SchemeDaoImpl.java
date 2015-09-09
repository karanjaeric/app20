package com.fundmaster.mss.dao.UImplement;

import java.util.List;

import javax.persistence.EntityManager;

import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.dao.UInterface.SchemeDao;
import com.fundmaster.mss.model.Scheme;

public class SchemeDaoImpl extends GenericModelDaoImpl<Scheme> implements SchemeDao{

	private EntityManager em;

	public SchemeDaoImpl() {
		super();
		// TODO Auto-generated constructor stub

		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}

	public List<Scheme> findAll() {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<Scheme> entities = em.createQuery("SELECT s FROM Scheme s").getResultList();
		em.close();
		return entities;
	}


	public Scheme findById(Long id) {
		// TODO Auto-generated method stub
		Scheme entity = em.find(Scheme.class, id);
		em.close();
		return entity;
	}

}
