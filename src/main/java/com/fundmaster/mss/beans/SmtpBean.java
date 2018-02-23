/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fundmaster.mss.beans;

import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.common.JLogger;
import com.fundmaster.mss.model.SmtpSetup;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ekaranja
 */
@Local
@Stateless
public class SmtpBean implements SmtpI {
     @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;
    JLogger jLogger = new JLogger(this.getClass());
    Helper helper = new Helper();

    @Override
    public SmtpSetup getSmtpSetup() {
        List<SmtpSetup> smtpSetup=entityManager.createQuery("SELECT S FROM SmtpSetup S").getResultList();
        if(smtpSetup.size()>0)
            return smtpSetup.get(0);
        return null;
        

    }

    @Override
    public SmtpSetup saveSmtpSetup(SmtpSetup smtpSetup) {
        
        return entityManager.merge(smtpSetup);
    }
    
}
