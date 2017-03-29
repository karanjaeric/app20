package com.fundmaster.mss.beans;

import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.PensionerMenuDAO;
import com.fundmaster.mss.model.PensionerMenu;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by tony on 3/29/17.
 */
@Stateless
@Local

public class PensionerMenuBean implements PensionerMenuBeanI {

    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)

    private EntityManager entityManager;

    @Override
    public PensionerMenu find() {
        PensionerMenuDAO dao = new PensionerMenuDAO(entityManager);
        return dao.find();
    }

    @Override
    public PensionerMenu edit(PensionerMenu pensionerMenu) {
        PensionerMenuDAO dao = new PensionerMenuDAO(entityManager);
        return dao.merge(pensionerMenu);
    }
}
