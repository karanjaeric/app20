package com.fundmaster.mss.dao;

import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.model.ActivityLog;
import com.fundmaster.mss.model.PieObject;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class ActivityLogDAO extends GenericDAOImpl<ActivityLog, Long> {
    private final EntityManager em;
    Helper helper = new Helper();
    public ActivityLogDAO(EntityManager entityManager)
    {
        super(ActivityLog.class, entityManager);
        em = entityManager;
    }

    public List<ActivityLog> findAllByUserID(String user_id) {
        // TODO Auto-generated method stub

        @SuppressWarnings("unchecked")
        List<ActivityLog> logs = em.createQuery("SELECT a FROM ActivityLog a WHERE a.userID=:user_id order by a.id desc").setParameter("user_id", helper.toLong(user_id)).setMaxResults(10).getResultList();

        return logs;
    }

    @SuppressWarnings("unchecked")
    public List<PieObject> findByFrontPageAccess()
    {
        List<Object[]> results = em.createQuery("SELECT a.access_menu AS access_menu, COUNT(access_menu) AS total FROM ActivityLog a WHERE access_menu != '' and access_menu IN ('" + Constants.PAGE_HOME + "', '" + Constants.PAGE_REGISTER + "', '" + Constants.PAGE_CONTACT_US + "', '" + Constants.PAGE_INTEREST_RATES + "', '" + Constants.PAGE_WHAT_IF_ANALYSIS + "') GROUP BY a.access_menu").getResultList();
        List<PieObject> poList = new ArrayList<>();
        for (Object[] result : results) {

            PieObject po = new PieObject(result[0].toString(), Double.parseDouble(result[1].toString()));

            poList.add(po);
        }
        return poList;
    }

    @SuppressWarnings("unchecked")
    public List<PieObject> findAccessByProfile()
    {
        List<Object[]> results = em.createQuery("SELECT a.userProfile AS userProfile, COUNT(userProfile) AS total FROM ActivityLog a WHERE userProfile != NULL GROUP BY a.userProfile").getResultList();
        List<PieObject> poList = new ArrayList<>();
        for (Object[] result : results) {

            PieObject po = new PieObject(result[0].toString(), Double.parseDouble(result[1].toString()));

            poList.add(po);
        }
        return poList;
    }

    @SuppressWarnings("unchecked")
    public List<PieObject> mostAccessedByMembers()
    {
        List<Object[]> results = em.createQuery("SELECT a.access_menu AS access_menu, COUNT(access_menu) AS total FROM ActivityLog a WHERE userProfile ='" + Constants.MEMBER_PROFILE + "' AND access_menu != NULL AND scheme != NULL GROUP BY a.access_menu").setMaxResults(5).getResultList();
        List<PieObject> poList = new ArrayList<>();
        for (Object[] result : results) {

            PieObject po = new PieObject(result[0].toString(), Double.parseDouble(result[1].toString()));

            poList.add(po);
        }
        return poList;
    }

    @SuppressWarnings("unchecked")
    public List<PieObject> mostAccessedByManagers()
    {
        List<Object[]> results = em.createQuery("SELECT a.access_menu AS access_menu, COUNT(access_menu) AS total FROM ActivityLog a WHERE userProfile !='" + Constants.MEMBER_PROFILE + "' AND access_menu != '' AND access_menu != '" + Constants.PAGE_LOGIN + "' AND userProfile != NULL  GROUP BY a.access_menu").setMaxResults(5).getResultList();
        List<PieObject> poList = new ArrayList<>();
        for (Object[] result : results) {

            PieObject po = new PieObject(result[0].toString(), Double.parseDouble(result[1].toString()));

            poList.add(po);
        }
        return poList;
    }
}
