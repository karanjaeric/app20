package com.fundmaster.mss.beans;

import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.ActivityLogDAO;
import com.fundmaster.mss.model.ActivityLog;
import com.fundmaster.mss.model.PieObject;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Stateless
@Local
public class ActivityLogBean implements ActivityLogBeanI {

    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;
    @Override
    public void add(ActivityLog activityLog) {
        ActivityLogDAO dao = new ActivityLogDAO(entityManager);
        dao.save(activityLog);
    }

    @Override
    public List<PieObject> findByFrontPageAccess() {
        ActivityLogDAO dao = new ActivityLogDAO(entityManager);
        return dao.findByFrontPageAccess();
    }

    @Override
    public List<ActivityLog> findAllByUserID(String user_id) {
        ActivityLogDAO dao = new ActivityLogDAO(entityManager);
        return dao.findAllByUserID(user_id);
    }

    @Override
    public List<PieObject> findAccessByProfile() {
        ActivityLogDAO dao = new ActivityLogDAO(entityManager);
        return dao.findAccessByProfile();
    }

    @Override
    public List<PieObject> mostAccessedByMembers() {
        ActivityLogDAO dao = new ActivityLogDAO(entityManager);
        return dao.mostAccessedByMembers();
    }

    @Override
    public List<PieObject> mostAccessedByManagers() {
        ActivityLogDAO dao = new ActivityLogDAO(entityManager);
        return dao.mostAccessedByManagers();
    }
}
