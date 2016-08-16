package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.SchemeMemberManager;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface SchemeManagerBeanI {

    SchemeMemberManager findByUserID(Long userID);
    List<SchemeMemberManager> findAllBySchemeID(String schemeID);
    void add(SchemeMemberManager schemeMemberManager);
    boolean delete(SchemeMemberManager schemeMemberManager);
    SchemeMemberManager findById(long id);
    List<SchemeMemberManager> findAll();
}
