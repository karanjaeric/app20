package com.fundmaster.mss.beans.beans;

import com.fundmaster.mss.beans.ejb.BenefitsCalculationEJB;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.BenefitCalculationsDao;
import com.fundmaster.mss.model.BenefitCalculation;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by bryanitur on 8/2/16.
 */
@Stateless
@Local
public class BenefitsCalculationBean implements BenefitsCalculationEJB {
    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public BenefitCalculation add(BenefitCalculation benefitCalculation) {
        BenefitCalculationsDao dao = new BenefitCalculationsDao(entityManager);
        return dao.save(benefitCalculation);
    }
}
