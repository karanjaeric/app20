package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.Sponsor;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class SponsorDAO extends GenericDAOImpl<Sponsor, Long> {
        private EntityManager em;
        public SponsorDAO(EntityManager entityManager)
        {
            super(Sponsor.class, entityManager);
            em = entityManager;
        }

    public List<Sponsor> findAll(String agentId, String search, int offset, int limit) {
        // TODO Auto-generated method stub
        String query;
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

        return entities;
    }


    @SuppressWarnings("unchecked")
    public int countAll(String search)
    {
        List<Sponsor> Sponsors;
        String query_string;
        if(search != null)
            query_string = "SELECT s FROM Sponsor s WHERE name like '%" + search + "%'";

        else

            query_string = "SELECT s FROM Sponsor s";
        Sponsors = em.createQuery(query_string).getResultList();
        return Sponsors.size();
    }
}
