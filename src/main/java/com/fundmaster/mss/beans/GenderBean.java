package com.fundmaster.mss.beans;

import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.GenderDAO;
import com.fundmaster.mss.model.Gender;

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
public class GenderBean implements GenderBeanI {


    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public Gender add(Gender gender) {
        GenderDAO dao = new GenderDAO(entityManager);
        return dao.save(gender);
    }

    @Override
    public Gender edit(Gender gender) {
        GenderDAO dao = new GenderDAO(entityManager);
        return dao.merge(gender);
    }

    @Override
    public List<Gender> find() {
        GenderDAO dao = new GenderDAO(entityManager);
        return dao.findAll();
    }

    @Override
    public boolean delete(Gender gender) {
        GenderDAO dao = new GenderDAO(entityManager);
        return dao.remove(gender);
    }
    @Override
    public Gender findById(long id) {
        GenderDAO dao = new GenderDAO(entityManager);
        return dao.findById(id);
    }
}
