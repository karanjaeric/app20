package com.fundmaster.mss.common;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class EntityManagerFactoryHelper {

	private static final EntityManagerFactory factory;

    static {
        try {
        	factory = Persistence.createEntityManagerFactory("Mss");
        } catch(ExceptionInInitializerError e) {
            throw e;
        }
    }

    public static EntityManagerFactory getFactory() {
        return factory;
    }
    
}
