package com.fundmaster.mss.dao.UImplement;

import java.util.List;

import javax.persistence.EntityManager;

import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.dao.UInterface.ContactCategoryDao;
import com.fundmaster.mss.model.ContactCategory;

public class ContactCategoryDaoImpl extends GenericModelDaoImpl<ContactCategory> implements ContactCategoryDao {


	private EntityManager em;

	public ContactCategoryDaoImpl() {
		super();
		// TODO Auto-generated constructor stub

		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}

	public List<ContactCategory> findAll() {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<ContactCategory> entities = em.createQuery("SELECT c FROM ContactCategory c").getResultList();
		em.close();
		return entities;
	}


	public ContactCategory findById(Long id) {
		// TODO Auto-generated method stub
		ContactCategory entity = em.find(ContactCategory.class, id);
		em.close();
		return entity;
	}

}
