package com.fundmaster.mss.dao.UImplement;

import java.util.List;

import javax.persistence.EntityManager;
import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.dao.UInterface.SocialDao;
import com.fundmaster.mss.model.Social;

public class SocialDaoImpl extends GenericModelDaoImpl<Social> implements SocialDao{

	private EntityManager em;

	public SocialDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}

	public List<Social> findAll() {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<Social> entities = em.createQuery("SELECT s FROM Social s").getResultList();
		em.close();
		return entities;
	}


	public Social findById(Long id) {
		// TODO Auto-generated method stub
		Social entity = em.find(Social.class, id);
		em.close();
		return entity;
	}
}
