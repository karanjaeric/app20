package com.fundmaster.mss.beans;

import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.EmailsDAO;
import com.fundmaster.mss.model.Emails;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by tony on 11/8/16.
 */

@Local
@Stateless
public class EmailsBean implements EmailsBeanI {

    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;
    @Override
    public Emails edit(Emails emails) {
        EmailsDAO dao = new EmailsDAO(entityManager);
        return dao.merge(emails);
    }

    @Override
    public Emails find() {
        EmailsDAO dao = new EmailsDAO(entityManager);
        return dao.find();
    }

}
