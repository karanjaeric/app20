package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.Member;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class MemberDAO extends GenericDAOImpl<Member, Long> {
    private final EntityManager em;
    public MemberDAO(EntityManager entityManager)
    {
        super(Member.class, entityManager);
        em = entityManager;
    }

    @SuppressWarnings("unchecked")
    public Member findByIDNumber(String idNumber) {
        // TODO Auto-generated method stub
        List<Member> results = em.createQuery("SELECT m FROM Member m WHERE m.idNumber=:idNumber").setParameter("idNumber", idNumber).getResultList();

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
        List<Member> members;
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

        return entities;
    }

    public Member findByPhoneNumber(String phoneNumber) {


            // TODO Auto-generated method stub
            return  (Member) em.createQuery("SELECT u FROM Member u WHERE u.phoneNumber=:phoneNumber").setParameter("phoneNumber", phoneNumber).getSingleResult();


    }
}
