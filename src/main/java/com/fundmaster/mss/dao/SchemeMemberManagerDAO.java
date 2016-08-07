package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.SchemeMemberManager;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class SchemeMemberManagerDAO extends GenericDAOImpl<SchemeMemberManager, Long> {
    private final EntityManager em;
    public SchemeMemberManagerDAO(EntityManager entityManager)
    {
        super(SchemeMemberManager.class, entityManager);
        em = entityManager;
    }

    public SchemeMemberManager findByUserID(Long userID) {
        // TODO Auto-generated method stub

        @SuppressWarnings("unchecked")
        List<SchemeMemberManager> logs = em.createQuery("SELECT a FROM SchemeMemberManager a WHERE user_id=:userID").setParameter("userID", userID).getResultList();

        try
        {
            return logs.get(0);
        }
        catch (Exception ex)
        {
            return null;
        }
    }

    public List<SchemeMemberManager> findAllBySchemeID(String schemeID) {
        // TODO Auto-generated method stub

        @SuppressWarnings("unchecked")
        List<SchemeMemberManager> logs = em.createQuery("SELECT a FROM SchemeMemberManager a WHERE schemeID=:schemeID order by a.id asc").setParameter("schemeID", schemeID).getResultList();

        return logs;
    }
}
