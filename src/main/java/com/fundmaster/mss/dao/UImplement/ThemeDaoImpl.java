package com.fundmaster.mss.dao.UImplement;

import java.util.List;

import javax.persistence.EntityManager;

import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.dao.UInterface.ThemeDao;
import com.fundmaster.mss.model.Theme;

public class ThemeDaoImpl extends GenericModelDaoImpl<Theme> implements ThemeDao {


	private EntityManager em;

	public ThemeDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}

	public List<Theme> findAll() {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<Theme> entities = em.createQuery("SELECT t FROM Theme t").getResultList();
		em.close();
		return entities;
	}


	public Theme findById(Long id) {
		// TODO Auto-generated method stub
		Theme entity = em.find(Theme.class, id);
		em.close();
		return entity;
	}
}
