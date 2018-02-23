/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.SmtpSetup;

/**
 *
 * @author ekaranja
 */
public interface SmtpI {
    
    SmtpSetup getSmtpSetup();
    SmtpSetup saveSmtpSetup(SmtpSetup smtpSetup);
    
}
