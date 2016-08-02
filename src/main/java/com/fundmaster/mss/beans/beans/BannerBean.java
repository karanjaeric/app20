package com.fundmaster.mss.beans.beans;

import com.fundmaster.mss.beans.ejb.BannerEJB;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.BannerDAO;
import com.fundmaster.mss.model.Banner;

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
public class BannerBean implements BannerEJB {


    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public Banner add(Banner banner) {
        BannerDAO dao = new BannerDAO(entityManager);
        return dao.save(banner);
    }

    @Override
    public Banner findById(long id) {
        BannerDAO dao = new BannerDAO(entityManager);
        return dao.findById(id);
    }

    @Override
    public boolean delete(Banner banner) {
        BannerDAO dao = new BannerDAO(entityManager);
        return dao.remove(banner);
    }

    @Override
    public List<Banner> find() {
        BannerDAO dao = new BannerDAO(entityManager);
        return dao.findAll();
    }
}
