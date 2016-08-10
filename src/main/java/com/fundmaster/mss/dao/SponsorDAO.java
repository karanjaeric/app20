package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.Sponsor;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class SponsorDAO extends GenericDAOImpl<Sponsor, Long> {
        private final EntityManager em;
        public SponsorDAO(EntityManager entityManager)
        {
            super(Sponsor.class, entityManager);
            em = entityManager;
        }

    public List<Sponsor> findAll(String agentId, String search, int offset, int limit) {
        // TODO Auto-generated method stub
        String query = "SELECT s FROM Sponsor s";
        if(agentId != null && search != null)
        {
            query += " WHERE s.agentId = '" + agentId + "' AND s.companyName LIKE '%" + search + "%'";
        }
        else if(agentId != null)
        {
            query += " WHERE s.agentId = '" + agentId + "'";
        }
        else if(search != null)
        {
            query += " WHERE s.companyName LIKE '%" + search + "%'";
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
            query_string = "SELECT s FROM Sponsor s WHERE s.companyName like '%" + search + "%'";

        else

            query_string = "SELECT s FROM Sponsor s";
        Sponsors = em.createQuery(query_string).getResultList();
        return Sponsors.size();
    }
}
