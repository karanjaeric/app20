package com.fundmaster.mss.beans;

import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.MemberMenuDAO;
import com.fundmaster.mss.model.MemberMenu;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by tony on 3/13/17.
 */
@Stateless
@Local
public class MemberMenuBean implements MemberMenuBeanI {

    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)

    private EntityManager entityManager;

    @Override
    public MemberMenu find() {
        MemberMenuDAO dao = new MemberMenuDAO(entityManager);
        return dao.find();
    }

    @Override
    public MemberMenu edit(MemberMenu memberMenu) {
        MemberMenuDAO dao = new MemberMenuDAO(entityManager);
        return dao.merge(memberMenu);
    }
}
