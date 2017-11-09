package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.AdminDashboardItems;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by tony on 3/24/17.
 */
public class AdminDashboardDAO extends GenericDAOImpl<AdminDashboardItems, Long> {

    public AdminDashboardDAO(EntityManager entityManager)
    {
        super(AdminDashboardItems.class, entityManager);
    }

    public AdminDashboardItems find()
    {
        List<AdminDashboardItems> adminDashboardItemses = this.findAll();
        return adminDashboardItemses.size() > 0 ? adminDashboardItemses.get(0) : null;
    }
}
