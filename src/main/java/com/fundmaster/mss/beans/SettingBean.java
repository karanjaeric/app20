package com.fundmaster.mss.beans;

import com.fundmaster.mss.beans.SettingBeanI;
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
public class SettingBean implements SettingBeanI {

    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
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
