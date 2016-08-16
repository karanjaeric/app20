package com.fundmaster.mss.beans;

import com.fundmaster.mss.beans.MenuBeanI;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.MenuDAO;
import com.fundmaster.mss.model.Menu;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Stateless
@Local
public class MenuBean implements MenuBeanI {

    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public Menu find() {
        MenuDAO dao = new MenuDAO(entityManager);
        return dao.find();
    }

    @Override
    public Menu edit(Menu menu) {
        MenuDAO dao = new MenuDAO(entityManager);
        return dao.merge(menu);
    }
}
