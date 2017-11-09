package com.fundmaster.mss.dao;

import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.common.JLogger;
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
    private final com.fundmaster.mss.common.JLogger jLogger = new JLogger(this.getClass());
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
        List<Object[]> results = em.createQuery("SELECT a.access_menu AS access_menu, COUNT(a.access_menu) AS total FROM ActivityLog a WHERE a.access_menu IN ('HOME', 'REGISTRATION', 'CONTACT_US', 'INTEREST_RATES', 'WHAT_IF_ANALYSIS') GROUP BY a.access_menu").getResultList();
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
        List<Object[]> results = em.createQuery("SELECT a.userProfile AS userProfile, COUNT(a.userProfile) AS total FROM ActivityLog a WHERE userProfile is not NULL GROUP BY a.userProfile").getResultList();
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
        List<Object[]> results = em.createQuery("SELECT a.access_menu AS access_menu, COUNT(access_menu) AS total FROM ActivityLog a WHERE userProfile ='MEMBER' AND access_menu is not NULL AND scheme is not NULL GROUP BY a.access_menu").setMaxResults(5).getResultList();
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
        List<Object[]> results = em.createQuery("SELECT a.access_menu AS access_menu, COUNT(a.access_menu) AS total FROM ActivityLog a WHERE userProfile !='MEMBER' AND access_menu != '' AND access_menu != 'LOGIN' AND userProfile is not NULL  GROUP BY a.access_menu").setMaxResults(5).getResultList();
        List<PieObject> poList = new ArrayList<>();
        for (Object[] result : results) {

            PieObject po = new PieObject(result[0].toString(), Double.parseDouble(result[1].toString()));

            poList.add(po);
        }
        return poList;
    }
}
