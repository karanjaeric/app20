package com.fundmaster.mss.dao.UImplement;

import java.util.List;

import javax.persistence.EntityManager;

import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.dao.UInterface.MenuDao;
import com.fundmaster.mss.model.Menu;

public class MenuDaoImpl  extends GenericModelDaoImpl<Menu> implements MenuDao{

	public MenuDaoImpl() {
		// TODO Auto-generated constructor stub
		super();
		// TODO Auto-generated constructor stub
		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}

	private EntityManager em;

	public List<Menu> findAll() {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<Menu> entities = em.createQuery("SELECT c FROM Menu c").getResultList();
		em.close();
		return entities;
	}


	public Menu findById(Long id) {
		// TODO Auto-generated method stub
		Menu entity = em.find(Menu.class, id);
		em.close();
		return entity;
	}
}
