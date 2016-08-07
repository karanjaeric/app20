package com.fundmaster.mss.beans.ejb;

import com.fundmaster.mss.model.ActivityLog;
import com.fundmaster.mss.model.PieObject;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface ActivityLogEJB {

    void add(ActivityLog activityLog);
    List<PieObject> findByFrontPageAccess();
    List<ActivityLog> findAllByUserID(String user_id);
    List<PieObject> findAccessByProfile();
    List<PieObject> mostAccessedByMembers();
    List<PieObject> mostAccessedByManagers();
}
