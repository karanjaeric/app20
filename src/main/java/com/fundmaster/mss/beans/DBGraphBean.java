package com.fundmaster.mss.beans;

import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.DBGraphDAO;
import com.fundmaster.mss.model.DBContributionGraph;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by tony on 2/20/17.
 */

@Stateless
@Local
public class DBGraphBean implements DBGraphBeanI {

    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public DBContributionGraph find() {
        DBGraphDAO dao = new DBGraphDAO(entityManager);
        return dao.find();
    }

    @Override
    public DBContributionGraph edit(DBContributionGraph dbContributionGraph) {
        DBGraphDAO dao = new DBGraphDAO(entityManager);
        return dao.merge(dbContributionGraph);
    }
}
