package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.DBContributionGraph;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by tony on 2/20/17.
 */
public class DBGraphDAO extends GenericDAOImpl<DBContributionGraph, Long>  {

    public DBGraphDAO(EntityManager entityManager)
    {
        super(DBContributionGraph.class, entityManager);
    }

    public DBContributionGraph find()
    {
        List<DBContributionGraph> menuList = this.findAll();
        return menuList.size() > 0 ? menuList.get(0) : null;
    }
}
