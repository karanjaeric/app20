package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.Help;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface HelpBeanI {

    Help add(Help help);
    void edit(Help help);
    List<Help> find();
    boolean delete(Help help);
    Help findHelp(String page);
    Help findById(long id);

}
