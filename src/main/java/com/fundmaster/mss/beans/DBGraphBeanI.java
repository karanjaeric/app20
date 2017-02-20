package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.DBContributionGraph;

import javax.ejb.Local;

/**
 * Created by tony on 2/20/17.
 */

@Local
public interface DBGraphBeanI {

    DBContributionGraph find();
    DBContributionGraph edit(DBContributionGraph dbContributionGraph);
}
