package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.ProfileLoginField;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class ProfileLoginFieldDAO extends GenericDAOImpl<ProfileLoginField, Long> {
    private EntityManager em;
    public ProfileLoginFieldDAO(EntityManager entityManager)
    {
        super(ProfileLoginField.class, entityManager);
        em = entityManager;
    }

    public ProfileLoginField findByProfile(String profile) {
        // TODO Auto-generated method stub
        @SuppressWarnings("unchecked")
        List<ProfileLoginField> logs = em.createQuery("SELECT p FROM ProfileLoginField p WHERE p.profile=:profile").setParameter("profile", profile).setMaxResults(5).getResultList();

        return logs.get(0);
    }

}
