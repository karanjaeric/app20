package com.fundmaster.mss.beans.ejbImplement;

import com.fundmaster.mss.beans.ejbInterface.SponsorEJB;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.SponsorDAO;
import com.fundmaster.mss.model.Sponsor;

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
public class SponsorBean implements SponsorEJB {

    @PersistenceContext(unitName = Constants.PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public Sponsor add(Sponsor sponsor) {
        SponsorDAO dao = new SponsorDAO(entityManager);
        return dao.save(sponsor);
    }

    @Override
    public Sponsor edit(Sponsor sponsor) {
        SponsorDAO dao = new SponsorDAO(entityManager);
        return dao.merge(sponsor);
    }

    @Override
    public Sponsor findById(long id) {
        SponsorDAO dao = new SponsorDAO(entityManager);
        return dao.findById(id);
    }

    @Override
    public List<Sponsor> findAll(String agentId, String search, int offset, int limit) {
        SponsorDAO dao = new SponsorDAO(entityManager);
        return dao.findAll(agentId, search, offset, limit);
    }

    @Override
    public boolean delete(Sponsor sponsor) {
        SponsorDAO dao = new SponsorDAO(entityManager);
        return dao.remove(sponsor);
    }
}
