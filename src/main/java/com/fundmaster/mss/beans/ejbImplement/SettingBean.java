package com.fundmaster.mss.beans.ejbImplement;

import com.fundmaster.mss.beans.ejbInterface.SettingEJB;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.SettingDAO;
import com.fundmaster.mss.model.Setting;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
@Stateless
public class SettingBean implements SettingEJB {

    @PersistenceContext(unitName = Constants.PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public Setting find() {
        SettingDAO dao = new SettingDAO(entityManager);
        return dao.find();
    }

    @Override
    public Setting edit(Setting setting) {
        SettingDAO dao = new SettingDAO(entityManager);
        return dao.merge(setting);
    }
}
