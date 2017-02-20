package com.fundmaster.mss.beans;

import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.JLogger;
import com.fundmaster.mss.dao.DBMenuDAO;
import com.fundmaster.mss.model.DBMenu;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by tony on 2/17/17.
 */

@Stateless
@Local
public class DBMenuBean implements DBMenuBeanI {
    private final JLogger jLogger = new JLogger(this.getClass());

    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public DBMenu find() {
        DBMenuDAO dao = new DBMenuDAO(entityManager);
        return dao.find();
    }

    @Override
    public DBMenu edit(DBMenu menu) {
        DBMenuDAO dao = new DBMenuDAO(entityManager);
        return dao.merge(menu);
    }
}
