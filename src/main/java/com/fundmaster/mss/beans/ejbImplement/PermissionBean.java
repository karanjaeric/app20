package com.fundmaster.mss.beans.ejbImplement;

import com.fundmaster.mss.beans.ejbInterface.PermissionEJB;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.PermissionDAO;
import com.fundmaster.mss.model.Permission;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Stateless
@Local
public class PermissionBean implements PermissionEJB {

    @PersistenceContext(unitName = Constants.PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public Permission findByProfile(String profile) {
        PermissionDAO dao = new PermissionDAO(entityManager);
        return dao.findByProfile(profile);
    }

    @Override
    public Permission edit(Permission permission) {
        PermissionDAO dao = new PermissionDAO(entityManager);
        return dao.merge(permission);
    }
}
