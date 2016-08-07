package com.fundmaster.mss.beans.beans;

import com.fundmaster.mss.beans.ejb.HelpEJB;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.HelpDAO;
import com.fundmaster.mss.model.Help;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Stateless
@Local
public class HelpBean implements HelpEJB {


    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public Help add(Help help) {
        HelpDAO dao = new HelpDAO(entityManager);
        return dao.save(help);
    }

    @Override
    public void edit(Help help) {
        HelpDAO dao = new HelpDAO(entityManager);
        dao.merge(help);
    }

    @Override
    public Help findById(long id) {
        HelpDAO dao = new HelpDAO(entityManager);
        return dao.findById(id);
    }

    @Override
    public List<Help> find() {
        HelpDAO dao = new HelpDAO(entityManager);
        return dao.findAll();
    }

    @Override
    public boolean delete(Help help) {
        HelpDAO dao = new HelpDAO(entityManager);
        return dao.remove(help);
    }

    @Override
    public Help findHelp(String page) {
        HelpDAO dao = new HelpDAO(entityManager);
        return dao.findHelp(page);
    }
}
