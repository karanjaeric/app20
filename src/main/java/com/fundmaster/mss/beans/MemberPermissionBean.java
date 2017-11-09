package com.fundmaster.mss.beans;

import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.MemberPermissionDAO;
import com.fundmaster.mss.model.MemberPermission;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
@Stateless
public class MemberPermissionBean implements MemberPermissionBeanI {


    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public MemberPermission edit(MemberPermission memberPermission) {
        MemberPermissionDAO dao = new MemberPermissionDAO(entityManager);
        return dao.merge(memberPermission);
    }

    @Override
    public MemberPermission find() {
        MemberPermissionDAO dao = new MemberPermissionDAO(entityManager);
        return dao.find();
    }
}
