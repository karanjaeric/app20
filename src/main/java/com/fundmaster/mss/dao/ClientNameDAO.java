package com.fundmaster.mss.dao;


import com.fundmaster.mss.model.ClientName;

import javax.persistence.EntityManager;

public class ClientNameDAO extends GenericDAOImpl<ClientName, Long> {
    public ClientNameDAO(EntityManager entityManager)
    {
        super(ClientName.class, entityManager);
    }
}
