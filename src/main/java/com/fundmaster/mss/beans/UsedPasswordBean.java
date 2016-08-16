package com.fundmaster.mss.beans;

import com.fundmaster.mss.beans.UsedPasswordBeanI;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.UsedPasswordDAO;
import com.fundmaster.mss.model.UsedPassword;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
@Stateless
public class UsedPasswordBean implements UsedPasswordBeanI {

    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public boolean isUsed(String password) {
        UsedPasswordDAO dao = new UsedPasswordDAO(entityManager);
        return dao.isUsed(password);
    }

    @Override
    public UsedPassword add(UsedPassword usedPassword) {
        UsedPasswordDAO dao = new UsedPasswordDAO(entityManager);
        return dao.save(usedPassword);
    }
}
