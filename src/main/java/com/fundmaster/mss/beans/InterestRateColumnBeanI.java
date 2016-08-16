package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.InterestRateColumns;

import javax.ejb.Local;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface InterestRateColumnBeanI {

    InterestRateColumns edit(InterestRateColumns interestRateColumns);
    InterestRateColumns find();

}
