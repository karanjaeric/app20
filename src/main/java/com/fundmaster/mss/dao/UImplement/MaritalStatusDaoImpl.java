package com.fundmaster.mss.dao.UImplement;

import java.util.List;

import javax.persistence.EntityManager;

import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.dao.UInterface.MaritalStatusDao;
import com.fundmaster.mss.model.MaritalStatus;

public class MaritalStatusDaoImpl extends GenericModelDaoImpl<MaritalStatus> implements MaritalStatusDao {

	private EntityManager em;

	public MaritalStatusDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}

	public List<MaritalStatus> findAll() {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<MaritalStatus> entities = em.createQuery("SELECT m FROM MaritalStatus m").getResultList();
		em.close();
		return entities;
	}

	public MaritalStatus findById(Long id) {
		// TODO Auto-generated method stub
		MaritalStatus entity = em.find(MaritalStatus.class, id);
		em.close();
		return entity;
	}

}
