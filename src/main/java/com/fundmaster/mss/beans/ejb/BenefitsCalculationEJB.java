package com.fundmaster.mss.beans.ejb;

import com.fundmaster.mss.model.BenefitCalculation;

import javax.ejb.Local;

/**
 * Created by bryanitur on 8/2/16.
 */
@Local
public interface BenefitsCalculationEJB {
    BenefitCalculation add(BenefitCalculation benefitCalculation);
}
