package com.fundmaster.mss.dao.UImplement;

import java.util.List;

import javax.persistence.EntityManager;

import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.dao.UInterface.CompanyDao;
import com.fundmaster.mss.model.Company;

public class CompanyDaoImpl extends GenericModelDaoImpl<Company> implements CompanyDao{


	private EntityManager em;

	public CompanyDaoImpl() {
		super();
		// TODO Auto-generated constructor stub

		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}

	public List<Company> findAll() {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<Company> entities = em.createQuery("SELECT c FROM Company c").getResultList();
		em.close();
		return entities;
	}


	public Company findById(Long id) {
		// TODO Auto-generated method stub
		Company entity = em.find(Company.class, id);
		em.close();
		return entity;
	}

}
