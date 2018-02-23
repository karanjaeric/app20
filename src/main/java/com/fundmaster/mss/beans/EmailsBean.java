package com.fundmaster.mss.beans;

import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.EmailsDAO;
import com.fundmaster.mss.model.Emails;
import java.util.Properties;
import javax.ejb.EJB;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by tony on 11/8/16.
 */

@Local
@Stateless
public class EmailsBean implements EmailsBeanI {
    
      @EJB
    SmtpI smtpBean;

    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;
    @Override
    public Emails edit(Emails emails) {
        EmailsDAO dao = new EmailsDAO(entityManager);
        return dao.merge(emails);
    }

    @Override
    public Emails find() {
        EmailsDAO dao = new EmailsDAO(entityManager);
        return dao.find();
    }

    @Override
    public void sendEmail(String message1,String to) {
        
       Properties props = new Properties();
        props.put("mail.smtp.host", smtpBean.getSmtpSetup().getSmtpHost()==null?"":smtpBean.getSmtpSetup().getSmtpHost());
        props.put("mail.smtp.socketFactory.port", smtpBean.getSmtpSetup().getSmtpPort()==null?465:smtpBean.getSmtpSetup().getSmtpPort());
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
       props.put("mail.smtp.port", smtpBean.getSmtpSetup().getSmtpPort()==null?465:smtpBean.getSmtpSetup().getSmtpPort());  
  
      Session session = Session.getInstance(props,  
    new javax.mail.Authenticator() {  
     @Override
     protected PasswordAuthentication getPasswordAuthentication() {  
      return new PasswordAuthentication(smtpBean.getSmtpSetup().getSmtpUsername(),smtpBean.getSmtpSetup().getSmtpPassword());  
     }  
      });  
        
      try{  
         MimeMessage message = new MimeMessage(session);  
         message.setFrom(new InternetAddress(smtpBean.getSmtpSetup().getSmtpUsername()));  
         message.addRecipient(Message.RecipientType.TO,  
                                  new InternetAddress(to));  
  
        message.setSubject("Mss Portal Account Activation");  
        message.setContent(message1,"text/html" );  
    
       Transport.send(message);  
         System.out.println("message sent....");  
      }catch (MessagingException ex) {ex.printStackTrace();}  
    }

}
