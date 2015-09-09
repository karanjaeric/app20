package com.fundmaster.mss.dao.UImplement;

import java.util.List;

import javax.persistence.EntityManager;

import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.dao.UInterface.MediaDao;
import com.fundmaster.mss.model.Media;

public class MediaDaoImpl extends GenericModelDaoImpl<Media> implements MediaDao{

	public MediaDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}


	private EntityManager em;
	@SuppressWarnings("unchecked")
	public List<Media> findAll(String schemeID, boolean admin) {
		// TODO Auto-generated method stub
		List<Media> entities;
		if(admin)
			entities = em.createQuery("SELECT m FROM Media m WHERE scheme=:scheme OR access = 'Public'").setParameter("scheme", schemeID).getResultList();
		else
			entities = em.createQuery("SELECT m FROM Media m WHERE scheme=:scheme OR access = 'Public'").setParameter("scheme", schemeID).getResultList();
		em.close();
		return entities;
	}


	public Media findById(Long id) {
		// TODO Auto-generated method stub
		Media entity = em.find(Media.class, id);
		em.close();
		return entity;
	}
}
