package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.ClientSetup;

import javax.persistence.EntityManager;
import java.util.List;

public class ClientSetupDAO extends GenericDAOImpl<ClientSetup, Long> {

    private final EntityManager em;
    public ClientSetupDAO(EntityManager entityManager)
    {
        super(ClientSetup.class, entityManager);
        em = entityManager;
    }



    public ClientSetup findByClientOrdinal(String clientOrdinal) {
        // TODO Auto-generated method stub
        @SuppressWarnings("unchecked")
        List<ClientSetup> logs = em.createQuery("SELECT c FROM ClientSetup c WHERE c.clientOrdinal=:clientOrdinal").setParameter("clientOrdinal", clientOrdinal).getResultList();

         return logs.size() > 0 ? logs.get(0) : null;
    }

}
