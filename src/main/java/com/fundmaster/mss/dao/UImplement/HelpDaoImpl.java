package com.fundmaster.mss.dao.UImplement;

import java.util.List;

import javax.persistence.EntityManager;
import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.dao.UInterface.HelpDao;
import com.fundmaster.mss.model.Help;

public class HelpDaoImpl extends GenericModelDaoImpl<Help> implements HelpDao{


	private EntityManager em;

	public HelpDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}

	public List<Help> findAll() {
		// TODO Auto-generated method stubd
		
		@SuppressWarnings("unchecked")
		List<Help> entities = em.createQuery("SELECT h FROM Help h").getResultList();
		em.close();
		return entities;
	}

	@SuppressWarnings("unchecked")
	public Help findHelp(String page)
	{
		// TODO Auto-generated method stub
		List<Help> results = em.createQuery("SELECT h FROM Help h WHERE h.page=:page").setParameter("page", page).getResultList();
		em.close();
		if (results.isEmpty()) {

            return null;

         }  else {

            return results.get(0);

         }
	}
	public Help findById(Long id) {
		// TODO Auto-generated method stub
		Help entity = em.find(Help.class, id);
		em.close();
		return entity;
	}
}
