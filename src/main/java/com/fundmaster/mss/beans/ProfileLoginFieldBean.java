package com.fundmaster.mss.beans;

import com.fundmaster.mss.beans.ProfileLoginFieldBeanI;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.ProfileLoginFieldDAO;
import com.fundmaster.mss.model.ProfileLoginField;

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
public class ProfileLoginFieldBean implements ProfileLoginFieldBeanI {

    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public ProfileLoginField edit(ProfileLoginField profileLoginField) {
        ProfileLoginFieldDAO dao = new ProfileLoginFieldDAO(entityManager);
        return dao.merge(profileLoginField);
    }

    @Override
    public String findByProfile(String profile) {
        ProfileLoginFieldDAO dao = new ProfileLoginFieldDAO(entityManager);
        ProfileLoginField profileLoginField = dao.findByProfile(profile);
        return profileLoginField == null ? null : profileLoginField.getOrdinal();
    }

    @Override
    public ProfileLoginField find(String profile) {
        ProfileLoginFieldDAO dao = new ProfileLoginFieldDAO(entityManager);
        return dao.findByProfile(profile);
    }
    @Override
    public List<ProfileLoginField> find() {
        ProfileLoginFieldDAO dao = new ProfileLoginFieldDAO(entityManager);
        return dao.findAll();
    }
}
