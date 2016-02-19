package com.fundmaster.mss.beans.ejbImplement;

import com.fundmaster.mss.beans.ejbInterface.MaritalStatusEJB;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.MaritalStatusDAO;
import com.fundmaster.mss.model.MaritalStatus;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
@Stateless
public class MaritalStatusBean implements MaritalStatusEJB {

    @PersistenceContext(unitName = Constants.PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public MaritalStatus add(MaritalStatus maritalStatus) {
        MaritalStatusDAO dao = new MaritalStatusDAO(entityManager);
        return dao.save(maritalStatus);
    }

    @Override
    public MaritalStatus edit(MaritalStatus maritalStatus) {
        MaritalStatusDAO dao = new MaritalStatusDAO(entityManager);
        return dao.merge(maritalStatus);
    }

    @Override
    public List<MaritalStatus> find() {
        MaritalStatusDAO dao = new MaritalStatusDAO(entityManager);
        return dao.findAll();
    }
}
