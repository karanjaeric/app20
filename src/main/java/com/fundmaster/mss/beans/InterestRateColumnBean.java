package com.fundmaster.mss.beans;

import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.InterestRateColumnsDAO;
import com.fundmaster.mss.model.InterestRateColumns;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
@Stateless
public class InterestRateColumnBean implements InterestRateColumnBeanI {
    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public InterestRateColumns edit(InterestRateColumns interestRateColumns) {
        InterestRateColumnsDAO dao = new InterestRateColumnsDAO(entityManager);
        return dao.merge(interestRateColumns);
    }

    @Override
    public InterestRateColumns find() {
        InterestRateColumnsDAO dao = new InterestRateColumnsDAO(entityManager);
        return dao.find();
    }
}
