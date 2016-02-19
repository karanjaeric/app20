package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.InterestRateColumns;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class InterestRateColumnsDAO extends GenericDAOImpl<InterestRateColumns, Long> {
    public InterestRateColumnsDAO(EntityManager entityManager)
    {
        super(InterestRateColumns.class, entityManager);
        EntityManager em = entityManager;
    }

    public InterestRateColumns find()
    {
        List<InterestRateColumns> interestRateColumnsList = this.findAll();
        return interestRateColumnsList.size() > 0 ? interestRateColumnsList.get(0) : null;
    }
}
