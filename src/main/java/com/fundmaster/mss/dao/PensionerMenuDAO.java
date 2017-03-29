package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.PensionerMenu;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by tony on 3/29/17.
 */
public class PensionerMenuDAO extends GenericDAOImpl<PensionerMenu, Long> {

    public PensionerMenuDAO(EntityManager entityManager)
    {
        super(PensionerMenu.class, entityManager);
    }

    public PensionerMenu find()
    {
        List<PensionerMenu> menuList = this.findAll();
        return menuList.size() > 0 ? menuList.get(0) : null;
    }
}
