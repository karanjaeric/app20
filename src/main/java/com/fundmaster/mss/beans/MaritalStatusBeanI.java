package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.MaritalStatus;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface MaritalStatusBeanI {

    MaritalStatus add(MaritalStatus maritalStatus);
    MaritalStatus edit(MaritalStatus maritalStatus);
    List<MaritalStatus> find();
    MaritalStatus findById(long id);
}
