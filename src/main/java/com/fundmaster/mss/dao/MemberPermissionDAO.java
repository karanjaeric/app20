package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.MemberPermission;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class MemberPermissionDAO extends GenericDAOImpl<MemberPermission, Long> {
    public MemberPermissionDAO(EntityManager entityManager)
    {
        super(MemberPermission.class, entityManager);
        EntityManager em = entityManager;
    }

    public MemberPermission find()
    {
        List<MemberPermission> memberPermissionList = this.findAll();
        return memberPermissionList.size() > 0 ? memberPermissionList.get(0) : null;
    }
}
