/*
 * Copyright (c) 2015 - 2015, Orion Tech Ltd. All rights reserved.
 * OrionWeb is a legal product of Orion Tech Ltd, Nairobi, Kenya. Orion Tech reserves the full rights on the product.
 */

package com.fundmaster.mss.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.fundmaster.mss.common.LOGGER;
import com.fundmaster.mss.model.Logo;

/**
 * Created by bryanitur on 9/16/15.
 */
public class GenericDAOImpl<T, PK> implements GenericDAO<T> {
    protected Class<T> entityClass;
    private EntityManager em;
    private LOGGER logger;

    public GenericDAOImpl(Class entityClass, EntityManager entityManager) {
        this.entityClass = entityClass;
        logger = new LOGGER(entityClass);
        this.em = entityManager;
    }

    public T findById(long id) {
        try {
            return em.find(entityClass, id);
        } catch(PersistenceException pe) {
            logger.e("We found a persistence exception executing findById " + pe.getMessage());
            return null;
        }
    }

    public T save(T entity) {
        try {
            em.persist(entity);
            return entity;
        } catch (PersistenceException pe) {
            logger.e("We found a persistence exception executing persist" + pe.getMessage());
            return null;
        }
    }
    
    public T update(T entity) {
    	try {
    		em.merge(entity);
    		return entity;
    	} catch (PersistenceException pe) {
            logger.e("We found a persistence exception executing persist" + pe.getMessage());
            return null;
        }
    }

    public T merge(T entity) {
        try {
            em.merge(entity);
            return entity;
        } catch (PersistenceException pe) {
            logger.e("We found a persistence exception executing merge" + pe.getMessage());
            return null;
        }
    }

    public long count() {
        return em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e").getResultList().size();
    }

    public boolean remove(T entity) {
        try {
        	em.remove(em.contains(entity) ? entity : em.merge(entity));
          //em.remove(entity);
            return true;
        } catch (PersistenceException pe) {
            logger.e("We found a persistence exception executing remove" + pe.getMessage());
            return false;
        }
    }

    public List<T> findAll() {
        try {
            String query = "SELECT e FROM " + entityClass.getSimpleName() + " e";
            List<T> results = em.createQuery(query).getResultList();
            return results;
        } catch (PersistenceException pe) {
            logger.e("We found a persistence exception executing findPaged" + pe.getMessage());
            return null;
        }
    }

    public List<T> findPaged(int start, int limit) {

        logger.i("Start: " + start + ", Limit: " + limit);
        try {
            String query = "SELECT e FROM " + entityClass.getSimpleName() + " e";
            List<T> results = em.createQuery(query).setFirstResult(start).setMaxResults(limit).getResultList();
            return results;
        } catch (PersistenceException pe) {
            logger.e("We found a persistence exception executing findPaged" + pe.getMessage());
            return null;
        }
    }

    public List<T> customQuery(String s, String value) {
        logger.i(s + " : " + value);
        try {
            List<T> results = em.createQuery(s).setParameter("value", value).getResultList();
            return results;
        } catch (PersistenceException pe) {
            logger.e("We found a persistence exception executing customQuery:" + pe.getMessage());
            return null;
        }
    }

    public List<T> customPagedQuery(String s, String value, int start, int limit) {
        logger.i(s + " : " + value);
        try {
            List<T> results = em.createQuery(s).setParameter("value", value).setFirstResult(start).setMaxResults(limit).getResultList();
            return results;
        } catch (PersistenceException pe) {
            logger.e("We found a persistence exception executing customQuery:" + pe.getMessage());
            return null;
        }
    }

    public List<T> query(String query) {
        try {
            List<T> results = em.createQuery(query).getResultList();
            return results;
        } catch (PersistenceException pe) {
            logger.e("We found a persistence exception executing query:" + pe.getMessage());
            return null;
        }
    }

    public List<T> findByObject(String s, Object o) {
        try {
            List<T> results = em.createQuery(s).setParameter("object", o).getResultList();
            return results;
        } catch (PersistenceException pe) {
            logger.e("We found a persistence exception executing findByObject:" + pe.getMessage());
            return null;
        }
    }
}