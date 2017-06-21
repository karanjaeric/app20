package com.fundmaster.mss.beans;

import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.FaqContentDAO;
import com.fundmaster.mss.model.FaqContent;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by tony on 6/13/17.
 */
@Stateless
@Local
public class FaqContentBean implements FaqContentBeanI {

    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public FaqContent edit(FaqContent faqContent) {
        FaqContentDAO dao = new FaqContentDAO(entityManager);
        return dao.merge(faqContent);
    }

    @Override
    public FaqContent findById(long id) {
        FaqContentDAO dao = new FaqContentDAO(entityManager);
        return dao.findById(id);
    }

    @Override
    public List<FaqContent> find() {
        FaqContentDAO dao = new FaqContentDAO(entityManager);
        return dao.findAll();
    }


    @Override
    public FaqContent findPageContent(String page) {
        FaqContentDAO dao = new FaqContentDAO(entityManager);
        return dao.findPageContent(page);
    }
}
