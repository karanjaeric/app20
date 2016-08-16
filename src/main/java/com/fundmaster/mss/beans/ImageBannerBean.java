package com.fundmaster.mss.beans;

import com.fundmaster.mss.beans.ImageBannerBeanI;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.BannerDAO;
import com.fundmaster.mss.model.ImageBanner;

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
public class ImageBannerBean implements ImageBannerBeanI {


    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public ImageBanner add(ImageBanner imageBanner) {
        BannerDAO dao = new BannerDAO(entityManager);
        return dao.save(imageBanner);
    }

    @Override
    public ImageBanner findById(long id) {
        BannerDAO dao = new BannerDAO(entityManager);
        return dao.findById(id);
    }

    @Override
    public boolean delete(ImageBanner imageBanner) {
        BannerDAO dao = new BannerDAO(entityManager);
        return dao.remove(imageBanner);
    }

    @Override
    public List<ImageBanner> find() {
        BannerDAO dao = new BannerDAO(entityManager);
        return dao.findAll();
    }
}
