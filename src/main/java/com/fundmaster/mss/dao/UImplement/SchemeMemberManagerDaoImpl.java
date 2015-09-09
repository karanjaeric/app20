package com.fundmaster.mss.dao.UImplement;

import java.util.List;

import javax.persistence.EntityManager;

import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.dao.UInterface.SchemeMemberManagerDao;
import com.fundmaster.mss.model.SchemeMemberManager;

public class SchemeMemberManagerDaoImpl extends GenericModelDaoImpl<SchemeMemberManager> implements SchemeMemberManagerDao {

	private EntityManager em;

	public SchemeMemberManagerDaoImpl() {
		super();
		// TODO Auto-generated constructor stub

		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}

	public SchemeMemberManager findByUserID(Long userID) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<SchemeMemberManager> logs = em.createQuery("SELECT a FROM SchemeMemberManager a WHERE user_id=:userID").setParameter("userID", userID).getResultList();
		em.close();
		try
		{
			return logs.get(0);
		}
		catch (Exception ex)
		{
			return null;
		}
	}

	public List<SchemeMemberManager> findAllBySchemeID(String schemeID) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<SchemeMemberManager> logs = em.createQuery("SELECT a FROM SchemeMemberManager a WHERE schemeID=:schemeID order by a.id asc").setParameter("schemeID", schemeID).getResultList();
		em.close();
		return logs;
	}

	public List<SchemeMemberManager> findAll() {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<SchemeMemberManager> entities = em.createQuery("SELECT a FROM SchemeMemberManager a").getResultList();
		em.close();
		return entities;
	}


	public SchemeMemberManager findById(Long id) {
		// TODO Auto-generated method stub
		SchemeMemberManager entity = em.find(SchemeMemberManager.class, id);
		em.close();
		return entity;
	}
}
