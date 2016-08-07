package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.Menu;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class MenuDAO extends GenericDAOImpl<Menu, Long> {
    public MenuDAO(EntityManager entityManager)
    {
        super(Menu.class, entityManager);
    }

    public Menu find()
    {
        List<Menu> menuList = this.findAll();
        return menuList.size() > 0 ? menuList.get(0) : null;
    }
}
