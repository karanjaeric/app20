package com.fundmaster.mss.beans;

import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.JLogger;
import com.fundmaster.mss.dao.AccountRecoveryDao;
import com.fundmaster.mss.model.AccountRecovery;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Local
public class AccountRecoveryBean implements AccountRecoveryBeanI {

    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public AccountRecovery find() {
        AccountRecoveryDao dao = new AccountRecoveryDao(entityManager);
        return dao.find();
    }

    @Override
    public AccountRecovery edit(AccountRecovery accountRecovery) {
        AccountRecoveryDao dao = new AccountRecoveryDao(entityManager);
        return dao.merge(accountRecovery);
    }
}
