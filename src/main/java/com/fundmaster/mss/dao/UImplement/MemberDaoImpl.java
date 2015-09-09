package com.fundmaster.mss.dao.UImplement;

import java.util.List;

import javax.persistence.EntityManager;

import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.dao.UInterface.MemberDao;
import com.fundmaster.mss.model.Member;

public class MemberDaoImpl extends GenericModelDaoImpl<Member> implements MemberDao{


	private EntityManager em;

	public MemberDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}

	@SuppressWarnings("unchecked")
	public Member findByIDNumber(String idNumber) {
		// TODO Auto-generated method stub
				List<Member> results = em.createQuery("SELECT m FROM Member m WHERE m.idNumber=:idNumber").setParameter("idNumber", idNumber).getResultList();
				em.close();
				if (results.isEmpty()) {

		            return null;

		         } else if (results.size() > 1) {

		            throw new IllegalStateException(

		                  "Cannot have more than member with the same credentials!");

		         } else {

		            return results.get(0);

		         }
	}
	
	@SuppressWarnings("unchecked")
	public int countAll(String search)
	{
		List<Member> members = null;
		String query_string;
		if(search != null)
			query_string = "SELECT m FROM Member m WHERE name like '%" + search + "%'";
		
		else

			query_string = "SELECT m FROM Member m";
		members = em.createQuery(query_string).getResultList();
		return members.size();
	}

	public List<Member> findAll(String agentId, String search, int offset, int limit) {
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
		if(query != null)
			query = "SELECT m FROM Member m " + query;
		else
			query = "SELECT m FROM Member m";
		@SuppressWarnings("unchecked")
		List<Member> entities = em.createQuery(query)
		         .setFirstResult(offset) 
		         .setMaxResults(limit).getResultList();
		em.close();
		return entities;
	}

	public Member findById(Long id) {
		// TODO Auto-generated method stub
		Member entity = em.find(Member.class, id);
		em.close();
		return entity;
	}
}
