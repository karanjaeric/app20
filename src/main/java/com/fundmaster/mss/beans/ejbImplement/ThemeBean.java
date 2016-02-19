package com.fundmaster.mss.beans.ejbImplement;

import com.fundmaster.mss.beans.ejbInterface.ThemeEJB;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.ThemeDAO;
import com.fundmaster.mss.model.Theme;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
@Stateless
public class ThemeBean implements ThemeEJB {
    @PersistenceContext(unitName = Constants.PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public Theme find() {
        ThemeDAO dao = new ThemeDAO(entityManager);
        return dao.find();
    }

    @Override
    public Theme edit(Theme theme) {
        ThemeDAO dao = new ThemeDAO(entityManager);
        return dao.merge(theme);
    }

    @Override
    public Theme findById(long id) {
        ThemeDAO dao = new ThemeDAO(entityManager);
        return dao.findById(id);
    }
}
