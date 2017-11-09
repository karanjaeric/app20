package com.fundmaster.mss.beans;

import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.BenefitCalculationsDao;
import com.fundmaster.mss.model.BenefitCalculation;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
/**
 * Created by bryanitur on 8/2/16.
 */
@Stateless
@Local
public class BenefitsCalculationBean implements BenefitsCalculationBeanI {
    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public void add(BenefitCalculation benefitCalculation) {
        BenefitCalculationsDao dao = new BenefitCalculationsDao(entityManager);
        dao.save(benefitCalculation);
    }
    @Override
    public List<BenefitCalculation> findAll(int start, int end) {
        BenefitCalculationsDao dao = new BenefitCalculationsDao(entityManager);
        return dao.findPaged(start, end);
    }
}
