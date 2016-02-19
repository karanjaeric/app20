package com.fundmaster.mss.beans.ejbInterface;

import com.fundmaster.mss.model.AuditTrail;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface AuditTrailEJB {

    List<AuditTrail>  findAllByUserName(String username);
    List<AuditTrail> frequenters(String from, String to);
    List<AuditTrail> findAll(String search, int offset, int limit);
    int countAll(String search);

}
