package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.AuditTrail;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class AuditTrailDAO extends GenericDAOImpl<AuditTrail, Long>{
    private final EntityManager em;
    public AuditTrailDAO(EntityManager entityManager)
    {
        super(AuditTrail.class, entityManager);
        em = entityManager;
    }


    public List<AuditTrail> findAllByUserName(String username) {
        // TODO Auto-generated method stub

        @SuppressWarnings("unchecked")
        List<AuditTrail> logs = em.createQuery("SELECT a FROM AuditTrail a WHERE username=:username order by a.id desc").setParameter("username", username).setMaxResults(10).getResultList();
        return logs;
    }


    public List<AuditTrail> frequenters(String from, String to) {
        // TODO Auto-generated method stub
        String query_string = "SELECT a FROM AuditTrail a WHERE DATE(datetime) >= '" + from + "' AND DATE(datetime) <= '" + to + "' GROUP BY username";
        @SuppressWarnings("unchecked")
        List<AuditTrail> entities = em.createQuery(query_string)
                .getResultList();

        return entities;
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
        return entities;
    }

    @SuppressWarnings("unchecked")
    public int countAll(String search)
    {
        List<AuditTrail> logs;
        String query_string;
        if(search != null)
            query_string = "SELECT a FROM AuditTrail a WHERE username like '%" + search + "%'";

        else

            query_string = "SELECT a FROM AuditTrail a";
        logs = em.createQuery(query_string).getResultList();
        return logs.size();
    }
}
