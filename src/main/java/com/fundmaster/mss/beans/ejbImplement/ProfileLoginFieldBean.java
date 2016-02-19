package com.fundmaster.mss.beans.ejbImplement;

import com.fundmaster.mss.beans.ejbInterface.ProfileLoginFieldEJB;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.ProfileLoginFieldDAO;
import com.fundmaster.mss.model.ProfileLoginField;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Stateless
@Local
public class ProfileLoginFieldBean implements ProfileLoginFieldEJB {

    @PersistenceContext(unitName = Constants.PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public ProfileLoginField edit(ProfileLoginField profileLoginField) {
        ProfileLoginFieldDAO dao = new ProfileLoginFieldDAO(entityManager);
        return dao.merge(profileLoginField);
    }

    @Override
    public ProfileLoginField findByProfile(String profile) {
        ProfileLoginFieldDAO dao = new ProfileLoginFieldDAO(entityManager);
        return dao.findByProfile(profile);
    }
}
