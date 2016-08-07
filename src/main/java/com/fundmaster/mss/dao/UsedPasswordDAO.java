package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.UsedPassword;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class UsedPasswordDAO extends GenericDAOImpl<UsedPassword, Long> {
    private final EntityManager em;
    public UsedPasswordDAO(EntityManager entityManager)
    {
        super(UsedPassword.class, entityManager);
        em = entityManager;
    }

    public boolean isUsed(String password)
    {
        @SuppressWarnings("unchecked")
        List<UsedPassword> usedPassword = em.createQuery("SELECT u FROM UsedPassword u WHERE password=:password").setParameter("password", password).getResultList();
        return usedPassword != null && usedPassword.size() > 0;
    }
}
