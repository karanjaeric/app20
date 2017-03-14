package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.MemberMenu;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by tony on 3/13/17.
 */
public class MemberMenuDAO extends GenericDAOImpl<MemberMenu, Long> {

    public MemberMenuDAO(EntityManager entityManager)
    {
        super(MemberMenu.class, entityManager);
    }

    public MemberMenu find()
    {
        List<MemberMenu> menuList = this.findAll();
        return menuList.size() > 0 ? menuList.get(0) : null;
    }
}
