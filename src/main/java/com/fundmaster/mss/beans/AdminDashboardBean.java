package com.fundmaster.mss.beans;

import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.controller.Admin;
import com.fundmaster.mss.dao.AdminDashboardDAO;
import com.fundmaster.mss.dao.MemberDashboardDAO;
import com.fundmaster.mss.model.AdminDashboardItems;
import com.fundmaster.mss.model.MemberDashboardItems;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by tony on 3/24/17.
 */
@Local
@Stateless
public class AdminDashboardBean implements AdminDashboardI {

    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)

    private EntityManager entityManager;

    @Override
    public AdminDashboardItems find() {
        AdminDashboardDAO dao = new AdminDashboardDAO(entityManager);
        return dao.find();
    }

    @Override
    public AdminDashboardItems edit(AdminDashboardItems adminDashboardItems) {
        AdminDashboardDAO dao = new AdminDashboardDAO(entityManager);
        return dao.merge(adminDashboardItems);
    }
}
