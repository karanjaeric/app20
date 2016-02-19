package com.fundmaster.mss.beans.ejbImplement;

import com.fundmaster.mss.beans.ejbInterface.PasswordPolicyEJB;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.PasswordPolicyDAO;
import com.fundmaster.mss.model.PasswordPolicy;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
@Stateless
public class PasswordPolicyBean implements PasswordPolicyEJB {

    @PersistenceContext(unitName = Constants.PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public PasswordPolicy edit(PasswordPolicy passwordPolicy) {
        PasswordPolicyDAO dao = new PasswordPolicyDAO(entityManager);
        return dao.merge(passwordPolicy);
    }

    @Override
    public PasswordPolicy find() {
        PasswordPolicyDAO dao = new PasswordPolicyDAO(entityManager);
        List<PasswordPolicy> passwordPolicyList = dao.findAll();
        return passwordPolicyList.size() > 0 ? passwordPolicyList.get(0) : null;
    }
}
