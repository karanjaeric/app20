package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.Emails;

import javax.ejb.Local;

/**
 * Created by tony on 11/8/16.
 */
@Local
public interface EmailsBeanI {

    Emails edit(Emails emails);
    Emails find();
    void sendEmail(String message,String to,String subject);
}
