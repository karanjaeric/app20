package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.AdminDashboardItems;

/**
 * Created by tony on 3/24/17.
 */
public interface AdminDashboardI {

    AdminDashboardItems find();
    AdminDashboardItems edit(AdminDashboardItems adminDashboardItems);
}
