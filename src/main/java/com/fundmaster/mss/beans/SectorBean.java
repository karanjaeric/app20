package com.fundmaster.mss.beans;

import com.fundmaster.mss.beans.SectorBeanI;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.SectorDAO;
import com.fundmaster.mss.model.Sector;

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
public class SectorBean implements SectorBeanI {

    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public Sector add(Sector sector) {
        SectorDAO dao = new SectorDAO(entityManager);
        return dao.save(sector);
    }

    @Override
    public Sector edit(Sector sector) {
        SectorDAO dao = new SectorDAO(entityManager);
        return dao.merge(sector);
    }

    @Override
    public List<Sector> find() {
        SectorDAO dao = new SectorDAO(entityManager);
        return dao.findAll();
    }

    @Override
    public boolean delete(Sector sector) {
        SectorDAO dao = new SectorDAO(entityManager);
        return dao.remove(sector);
    }
    @Override
    public Sector findById(long id) {
        SectorDAO dao = new SectorDAO(entityManager);
        return dao.findById(id);
    }
}
