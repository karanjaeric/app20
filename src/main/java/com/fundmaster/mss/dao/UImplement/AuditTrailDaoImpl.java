package com.fundmaster.mss.dao.UImplement;

import java.util.List;

import javax.persistence.EntityManager;

import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.dao.UInterface.GenericModelDao;
import com.fundmaster.mss.model.AuditTrail;

public class AuditTrailDaoImpl extends GenericModelDaoImpl<AuditTrail> implements GenericModelDao<AuditTrail> {

	private EntityManager em;

	public AuditTrailDaoImpl() {
		super();
		// TODO Auto-generated constructor stub

		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}

	public List<AuditTrail> findAllByUserName(String username) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<AuditTrail> logs = em.createQuery("SELECT a FROM AuditTrail a WHERE username=:username order by a.id desc").setParameter("username", username).setMaxResults(10).getResultList();
		em.close();
		return logs;
	}

	public List<AuditTrail> findAll(String search, int offset, int limit) {
		// TODO Auto-generated method stub
		String query_string;
		if(search != null)
			query_string = "SELECT a FROM AuditTrail a WHERE username like '%" + search + "%' order by a.id desc";
		else
			query_string = "SELECT a FROM AuditTrail a order by a.id desc";
		@SuppressWarnings("unchecked")
		List<AuditTrail> entities = em.createQuery(query_string)
		         .setFirstResult(offset) 
		         .setMaxResults(limit)
		         .getResultList();
		em.close();
		return entities;
	}
	
	@SuppressWarnings("unchecked")
	public int countAll(String search)
	{
		List<AuditTrail> logs = null;
		String query_string;
		if(search != null)
			query_string = "SELECT a FROM AuditTrail a WHERE username like '%" + search + "%'";
		
		else

			query_string = "SELECT a FROM AuditTrail a";
		logs = em.createQuery(query_string).getResultList();
		return logs.size();
	}


	public AuditTrail findById(Long id) {
		// TODO Auto-generated method stub
		AuditTrail entity = em.find(AuditTrail.class, id);
		em.close();
		return entity;
	}
}
