package com.fundmaster.mss.dao.UImplement;

import java.util.List;

import javax.persistence.EntityManager;
import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.dao.UInterface.BannerDao;
import com.fundmaster.mss.model.Banner;

public class BannerDaoImpl extends GenericModelDaoImpl<Banner> implements BannerDao {


	private EntityManager em;

	public BannerDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}

	public List<Banner> findAll() {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<Banner> entities = em.createQuery("SELECT b FROM Banner b").getResultList();
		em.close();
		return entities;
	}


	public Banner findById(Long id) {
		// TODO Auto-generated method stub
		Banner entity = em.find(Banner.class, id);
		em.close();
		return entity;
	}
}
