package com.fundmaster.mss.beans.ejb;

import com.fundmaster.mss.model.Gender;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface GenderEJB {

    Gender add(Gender gender);
    Gender edit(Gender gender);
    List<Gender> find();
    boolean delete(Gender gender);

}
