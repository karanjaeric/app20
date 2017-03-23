package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.MemberDashboardItems;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by tony on 3/23/17.
 */
public class MemberDashboardDAO extends GenericDAOImpl<MemberDashboardItems, Long> {

    public MemberDashboardDAO(EntityManager entityManager)
    {
        super(MemberDashboardItems.class, entityManager);
    }

    public MemberDashboardItems find()
    {
        List<MemberDashboardItems> memberDashboardItemses = this.findAll();
        return memberDashboardItemses.size() > 0 ? memberDashboardItemses.get(0) : null;
    }
}
