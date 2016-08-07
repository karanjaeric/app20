package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.BenefitCalculation;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class BenefitCalculationsDao extends GenericDAOImpl<BenefitCalculation, Long> {
    public BenefitCalculationsDao(EntityManager entityManager)
    {
        super(BenefitCalculationsDao.class, entityManager);
    }

    public BenefitCalculation find()
    {
        List<BenefitCalculation> benefitCalculations = this.findAll();
        return benefitCalculations.size() > 0 ? benefitCalculations.get(0) : null;
    }
}
