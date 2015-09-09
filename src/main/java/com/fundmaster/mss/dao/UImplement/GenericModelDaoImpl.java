package com.fundmaster.mss.dao.UImplement;


import java.util.logging.Logger;

import javax.persistence.EntityManager;

import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.dao.UInterface.GenericModelDao;
import com.fundmaster.mss.model.GenericModel;

public class GenericModelDaoImpl <T extends GenericModel<?>> implements GenericModelDao<T> {
	protected Class<T> entityClass;

	private EntityManager em;

	public GenericModelDaoImpl() {
		// TODO Auto-generated constructor stub
		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}	

	public void persist(T entity) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();
	}

	public void update(T entity) {
		// TODO Auto-generated method stub

		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		em.close();
	}

	public void delete(T entity) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.remove(em.contains(entity) ? entity : em.merge(entity));
		Logger.getAnonymousLogger().info("Deleted: " + entity.toString());
		em.getTransaction().commit();
		em.close();
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.createQuery("DELETE FROM " + entityClass.toString());
		em.getTransaction().commit();
		em.close();
	}

}
