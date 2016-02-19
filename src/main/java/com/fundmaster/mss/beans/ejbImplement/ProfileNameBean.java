package com.fundmaster.mss.beans.ejbImplement;

import com.fundmaster.mss.beans.ejbInterface.ProfileNameEJB;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.ProfileNameDAO;
import com.fundmaster.mss.model.ProfileLoginField;
import com.fundmaster.mss.model.ProfileName;

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
public class ProfileNameBean implements ProfileNameEJB {

    @PersistenceContext(unitName = Constants.PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public ProfileName edit(ProfileName profileName) {
        ProfileNameDAO dao = new ProfileNameDAO(entityManager);
        return dao.merge(profileName);
    }

    @Override
    public List<ProfileName> find() {
        ProfileNameDAO dao = new ProfileNameDAO(entityManager);
        return dao.findAll();
    }
}
