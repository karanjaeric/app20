package com.fundmaster.mss.beans;

import com.fundmaster.mss.beans.MediaBeanI;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.MediaDAO;
import com.fundmaster.mss.model.Media;

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
public class MediaBean implements MediaBeanI {


    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public Media findById(long id) {
        MediaDAO dao = new MediaDAO( entityManager);
        return dao.findById(id);
    }

    @Override
    public Media add(Media media) {
        MediaDAO dao = new MediaDAO(entityManager);
        return dao.save(media);
    }

    @Override
    public Media edit(Media media) {
        MediaDAO dao = new MediaDAO(entityManager);
        return dao.merge(media);
    }

    @Override
    public List<Media> findAll(String schemeID, String profile, String memberId) {
        MediaDAO dao = new MediaDAO(entityManager);
        return dao.findAll();
    }

    @Override
    public boolean delete(Media media) {
        MediaDAO dao = new MediaDAO(entityManager);
        return dao.remove(media);
    }
}
