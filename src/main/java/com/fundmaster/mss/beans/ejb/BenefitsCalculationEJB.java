package com.fundmaster.mss.beans.ejb;

import com.fundmaster.mss.model.BenefitCalculation;

import javax.ejb.Local;
import java.util.List;
/**
 * Created by bryanitur on 8/2/16.
 */
@Local
public interface BenefitsCalculationEJB {
    void add(BenefitCalculation benefitCalculation);
    List<BenefitCalculation> findAll(int start, int end);
}
