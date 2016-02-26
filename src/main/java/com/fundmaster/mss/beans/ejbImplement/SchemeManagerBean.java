package com.fundmaster.mss.beans.ejbImplement;

import com.fundmaster.mss.beans.ejbInterface.SchemeManagerEJB;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.SchemeMemberManagerDAO;
import com.fundmaster.mss.model.SchemeMemberManager;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
@Stateless
public class SchemeManagerBean implements SchemeManagerEJB {

    @PersistenceContext(unitName = Constants.PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public SchemeMemberManager findByUserID(Long userID) {
        SchemeMemberManagerDAO dao = new SchemeMemberManagerDAO(entityManager);
        return dao.findByUserID(userID);
    }

    @Override
    public SchemeMemberManager findById(long id) {
        SchemeMemberManagerDAO dao = new SchemeMemberManagerDAO(entityManager);
        return dao.findById(id);
    }

    @Override
    public List<SchemeMemberManager> findAllBySchemeID(String schemeID) {
        SchemeMemberManagerDAO dao = new SchemeMemberManagerDAO(entityManager);
        return dao.findAllBySchemeID(schemeID);
    }

    @Override
    public SchemeMemberManager add(SchemeMemberManager schemeMemberManager) {
        SchemeMemberManagerDAO dao = new SchemeMemberManagerDAO(entityManager);
        return dao.save(schemeMemberManager);
    }

    @Override
    public boolean delete(SchemeMemberManager schemeMemberManager) {
        SchemeMemberManagerDAO dao = new SchemeMemberManagerDAO(entityManager);
        return dao.remove(schemeMemberManager);
    }
}