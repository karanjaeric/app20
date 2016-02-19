package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.ContactCategory;

import javax.persistence.EntityManager;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class ContactCategoryDAO extends GenericDAOImpl<ContactCategory, Long> {
    public ContactCategoryDAO(EntityManager entityManager)
    {
        super(ContactCategory.class, entityManager);
        EntityManager em = entityManager;
    }
}
