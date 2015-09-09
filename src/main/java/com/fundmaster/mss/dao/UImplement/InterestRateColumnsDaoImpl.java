package com.fundmaster.mss.dao.UImplement;

import java.util.List;

import javax.persistence.EntityManager;

import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.dao.UInterface.InterestRateColumnsDao;
import com.fundmaster.mss.model.InterestRateColumns;

public class InterestRateColumnsDaoImpl extends GenericModelDaoImpl<InterestRateColumns> implements InterestRateColumnsDao{


	private EntityManager em;

	public InterestRateColumnsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub

		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}

	public List<InterestRateColumns> findAll() {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<InterestRateColumns> entities = em.createQuery("SELECT i FROM InterestRateColumns i").getResultList();
		em.close();
		return entities;
	}


	public InterestRateColumns findById(Long id) {
		// TODO Auto-generated method stub
		InterestRateColumns entity = em.find(InterestRateColumns.class, id);
		em.close();
		return entity;
	}

}
