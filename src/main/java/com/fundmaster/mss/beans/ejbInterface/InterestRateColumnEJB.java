package com.fundmaster.mss.beans.ejbInterface;

import com.fundmaster.mss.model.InterestRateColumns;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface InterestRateColumnEJB {

    InterestRateColumns edit(InterestRateColumns interestRateColumns);
    InterestRateColumns find();

}
