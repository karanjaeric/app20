package com.fundmaster.mss.beans;

import com.fundmaster.mss.beans.MediaBeanI;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.JLogger;
import com.fundmaster.mss.dao.MediaDAO;
import com.fundmaster.mss.model.Media;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
@Stateless
public class MediaBean implements MediaBeanI {

    JLogger jLogger = new JLogger(this.getClass());

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
    public List<Media> findByStatusAndProfile(String schemeId, boolean status, String Profile) {

        jLogger.i("The schemeId: " + schemeId);
        jLogger.i("The status: " + status);
        jLogger.i("The Profile: " + Profile);

        List<Media> medias = new ArrayList<Media>();
        Session session = (Session) entityManager.getDelegate();
        Criteria crit = session.createCriteria(Media.class);

        if (schemeId != null && !schemeId.isEmpty()) {

            crit.add(Restrictions.eq("schemeID", schemeId));
        }

        if (Profile.equalsIgnoreCase("administrator")) {
            crit.add(Restrictions.eq("administrator", status));
        }
        if (Profile.equalsIgnoreCase("member")) {
            crit.add(Restrictions.eq("member", status));
        }
        if (Profile.equalsIgnoreCase("sponsor")) {
            crit.add(Restrictions.eq("sponsor", status));
        }
        if (Profile.equalsIgnoreCase("agent")) {
            crit.add(Restrictions.eq("agent", status));
        }
        if (Profile.equalsIgnoreCase("crm")) {
            crit.add(Restrictions.eq("crm", status));
        }
        if (Profile.equalsIgnoreCase("trustee")) {
            crit.add(Restrictions.eq("trustee", status));
        }
        if (Profile.equalsIgnoreCase("custodian")) {
            crit.add(Restrictions.eq("custodian", status));
        }
        if (Profile.equalsIgnoreCase("cre")) {
            crit.add(Restrictions.eq("cre", status));
        }
        if (Profile.equalsIgnoreCase("fundManager")) {
            crit.add(Restrictions.eq("fundManager", status));
        }
        if (Profile.equalsIgnoreCase("pensioner")) {
            crit.add(Restrictions.eq("pensioner", status));
        }
        medias = crit.list();
        return medias;

    }

    @Override
    public List<Media> findByMemberId(String schemeId, String memberId) {

        jLogger.i("The schemeId: " + schemeId);
        jLogger.i("The ID: " + memberId);

        Long memberID = Long.parseLong(memberId);

        List<Media> medias = new ArrayList<Media>();
        Session session = (Session) entityManager.getDelegate();
        Criteria crit = session.createCriteria(Media.class);

        if (schemeId != null && !schemeId.isEmpty()) {

            crit.add(Restrictions.eq("schemeID", schemeId));
        }

        if (memberID != null) {
            crit.add(Restrictions.eq("memberId", memberID));
        }
        medias = crit.list();
        return medias;

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
