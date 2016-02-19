package com.fundmaster.mss.beans.ejbImplement;

import com.fundmaster.mss.beans.ejbInterface.PageContentEJB;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.PageContentDAO;
import com.fundmaster.mss.model.PageContent;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Stateless
@Local
public class PageContentBean implements PageContentEJB {

    @PersistenceContext(unitName = Constants.PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public PageContent edit(PageContent pageContent) {
        PageContentDAO dao = new PageContentDAO(entityManager);
        return dao.merge(pageContent);
    }

    @Override
    public PageContent findById(long id) {
        PageContentDAO dao = new PageContentDAO(entityManager);
        return dao.findById(id);
    }

    @Override
    public List<PageContent> find() {
        PageContentDAO dao = new PageContentDAO(entityManager);
        return dao.findAll();
    }

    @Override
    public PageContent findPageContent(String page) {
        PageContentDAO dao = new PageContentDAO(entityManager);
        return dao.findPageContent(page);
    }
}
