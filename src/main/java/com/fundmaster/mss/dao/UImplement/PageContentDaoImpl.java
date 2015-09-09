package com.fundmaster.mss.dao.UImplement;

import java.util.List;

import javax.persistence.EntityManager;

import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.dao.UInterface.PageContentDao;
import com.fundmaster.mss.model.PageContent;

public class PageContentDaoImpl extends GenericModelDaoImpl<PageContent> implements PageContentDao {

	private EntityManager em;

	public PageContentDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}

	public List<PageContent> findAll() {
		// TODO Auto-generated method stubd
		
		@SuppressWarnings("unchecked")
		List<PageContent> entities = em.createQuery("SELECT p FROM PageContent p").getResultList();
		em.close();
		return entities;
	}

	@SuppressWarnings("unchecked")
	public PageContent findPageContent(String page)
	{
		// TODO Auto-generated method stub
		List<PageContent> results = em.createQuery("SELECT p FROM PageContent p WHERE p.page=:page").setParameter("page", page).getResultList();
		em.close();
		if (results.isEmpty()) {

            return null;

         }  else {

            return results.get(0);

         }
	}
	public PageContent findById(Long id) {
		// TODO Auto-generated method stub
		PageContent entity = em.find(PageContent.class, id);
		return entity;
	}

}
