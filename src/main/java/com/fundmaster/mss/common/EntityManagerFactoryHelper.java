package com.fundmaster.mss.common;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jboss.logging.Logger;

public class EntityManagerFactoryHelper {

	private static EntityManagerFactory factory;

    static {
        try {
           // Set up factory right here
        	factory = Persistence.createEntityManagerFactory("Mss");
        	Logger.getLogger(EntityManagerFactory.class).info("Created entity manager factory");
        } catch(ExceptionInInitializerError e) {
            throw e;
        }
    }

    public static EntityManagerFactory getFactory() {
    	Logger.getLogger(EntityManagerFactory.class).info("Returned entity manager factory");
        return factory;
    }
    
}
