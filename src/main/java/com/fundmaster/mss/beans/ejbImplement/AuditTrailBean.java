package com.fundmaster.mss.beans.ejbImplement;

import com.fundmaster.mss.beans.ejbInterface.AuditTrailEJB;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.AuditTrailDAO;
import com.fundmaster.mss.model.AuditTrail;

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
public class AuditTrailBean implements AuditTrailEJB{

    @PersistenceContext(unitName = Constants.PERSISTENCE_UNIT)
    private EntityManager entityManager;
    @Override
    public List<AuditTrail> findAllByUserName(String username) {
        AuditTrailDAO dao = new AuditTrailDAO(entityManager);
        return dao.findAllByUserName(username);
    }

    @Override
    public List<AuditTrail> frequenters(String from, String to) {
        AuditTrailDAO dao = new AuditTrailDAO(entityManager);
        return dao.frequenters(from, to);
    }

    @Override
    public List<AuditTrail> findAll(String search, int offset, int limit) {
        AuditTrailDAO dao = new AuditTrailDAO(entityManager);
        return dao.findAll();
    }

    @Override
    public int countAll(String search) {
        AuditTrailDAO dao = new AuditTrailDAO(entityManager);
        return dao.countAll(search);
    }
}
