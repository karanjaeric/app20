package com.fundmaster.mss.dao.UImplement;

import java.util.List;

import javax.persistence.EntityManager;

import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.dao.UInterface.SponsorDao;
import com.fundmaster.mss.model.Sponsor;

public class SponsorDaoImpl extends GenericModelDaoImpl<Sponsor> implements SponsorDao{

	private EntityManager em;

	public SponsorDaoImpl() {
		super();
		// TODO Auto-generated constructor stub

		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}

	public List<Sponsor> findAll(String agentId, String search, int offset, int limit) {
		// TODO Auto-generated method stub
		String query = null;
		if(agentId != null && search != null)
		{
			 query = "WHERE agentId = '" + agentId + "' AND name LIKE '%" + search + "%'";
		}
		else if(agentId != null)
		{
			query = "WHERE agentId = '" + agentId + "'";
		}
		else if(search != null)
		{
			 query = "WHERE name LIKE '%" + search + "%'";
		}
		else {
			query = "SELECT s FROM Sponsor s";
		}
		@SuppressWarnings("unchecked")
		List<Sponsor> entities = em.createQuery(query)
		         .setFirstResult(offset) 
		         .setMaxResults(limit).getResultList();
		em.close();
		return entities;
	}

	
	@SuppressWarnings("unchecked")
	public int countAll(String search)
	{
		List<Sponsor> Sponsors = null;
		String query_string;
		if(search != null)
			query_string = "SELECT s FROM Sponsor s WHERE name like '%" + search + "%'";
		
		else

			query_string = "SELECT s FROM Sponsor s";
		Sponsors = em.createQuery(query_string).getResultList();
		return Sponsors.size();
	}

	public Sponsor findById(Long id) {
		// TODO Auto-generated method stub
		Sponsor entity = em.find(Sponsor.class, id);
		em.close();
		return entity;
	}
}
