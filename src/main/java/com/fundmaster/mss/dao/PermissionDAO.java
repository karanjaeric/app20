package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.Permission;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class PermissionDAO extends GenericDAOImpl<Permission, Long> {
    private final EntityManager em;
    public PermissionDAO(EntityManager entityManager)
    {
        super(Permission.class, entityManager);
        em = entityManager;
    }

    public Permission findByProfile(String profile) {
        // TODO Auto-generated method stub

        @SuppressWarnings("unchecked")
        List<Permission> logs = em.createQuery("SELECT p FROM Permission p WHERE profile=:profile").setParameter("profile", profile).getResultList();

        return logs.get(0);
    }
}
