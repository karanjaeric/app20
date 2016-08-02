package com.fundmaster.mss.beans.beans;

import com.fundmaster.mss.beans.ejb.SocialEJB;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.SocialDAO;
import com.fundmaster.mss.model.Social;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
@Stateless
public class SocialBean implements SocialEJB {

    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public Social edit(Social social) {
        SocialDAO dao = new SocialDAO(entityManager);
        return dao.merge(social);
    }

    @Override
    public Social find() {
        SocialDAO dao = new SocialDAO(entityManager);
        List<Social> socialList = dao.findAll();
        return socialList.size() > 0 ? socialList.get(0) : null;
    }
}
