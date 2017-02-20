package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.DBMenu;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by tony on 2/17/17.
 */
public class DBMenuDAO extends GenericDAOImpl<DBMenu, Long> {

    public DBMenuDAO(EntityManager entityManager)
    {
        super(DBMenu.class, entityManager);
    }

    public DBMenu find()
    {
        List<DBMenu> menuList = this.findAll();
        return menuList.size() > 0 ? menuList.get(0) : null;
    }
}
