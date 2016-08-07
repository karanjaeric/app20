package com.fundmaster.mss.dao;

import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.model.Media;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class MediaDAO extends GenericDAOImpl<Media, Long> {
    private final EntityManager em;
    public MediaDAO(EntityManager entityManager)
    {
        super(Media.class, entityManager);
        em = entityManager;
    }
    @SuppressWarnings("unchecked")
    public List<Media> findAll(String schemeID, String profile, String memberId) {
        // TODO Auto-generated method stub
        List<Media> entities;
        String field = getField(profile);
        if(profile.equals(Constants.MEMBER_PROFILE))
            entities = em.createQuery("SELECT m FROM Media m WHERE m.schemeID=:scheme AND m." + field + " = 1 AND (memberId =:member_id OR memberId =:null_member)").setParameter("member_id", Long.valueOf(memberId)).setParameter("null_member",  Long.valueOf("0")).setParameter("scheme", schemeID).getResultList();
        else
            entities = em.createQuery("SELECT m FROM Media m WHERE m.schemeID=:scheme AND m." + field + " = 1").setParameter("scheme", schemeID).getResultList();

        return entities;
    }

    private String getField(String profile)

    {

        switch (profile) {
            case "CUSTOMER_RELATIONSHIP_MANAGER":
                return "crm";
            case "CUSTOMER_RELATIONSHIP_EXECUTIVE":
                return "cre";
            case "FUND_MANAGER":
                return "fundManager";
            default:
                return profile.toLowerCase();
        }

    }
}
