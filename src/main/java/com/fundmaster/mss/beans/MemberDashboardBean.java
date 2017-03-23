package com.fundmaster.mss.beans;

import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.MemberDashboardDAO;
import com.fundmaster.mss.model.MemberDashboardItems;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by tony on 3/23/17.
 */
@Local
@Stateless
public class MemberDashboardBean implements MemberDashboardBeanI {

    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)

    private EntityManager entityManager;

    @Override
    public MemberDashboardItems find() {
        MemberDashboardDAO dao = new MemberDashboardDAO(entityManager);
        return dao.find();
    }

    @Override
    public MemberDashboardItems edit(MemberDashboardItems memberDashboardItems) {
        MemberDashboardDAO dao = new MemberDashboardDAO(entityManager);
        return dao.merge(memberDashboardItems);
    }
}
