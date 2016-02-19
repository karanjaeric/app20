package com.fundmaster.mss.beans.ejbImplement;

import com.fundmaster.mss.beans.ejbInterface.ContactCategoryEJB;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.ContactCategoryDAO;
import com.fundmaster.mss.model.ContactCategory;

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
public class ContactCategoryBean implements ContactCategoryEJB {


    @PersistenceContext(unitName = Constants.PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public ContactCategory add(ContactCategory contactCategory) {
        ContactCategoryDAO dao = new ContactCategoryDAO(entityManager);
        return dao.save(contactCategory);
    }

    @Override
    public ContactCategory findById(long id) {
        ContactCategoryDAO dao = new ContactCategoryDAO(entityManager);
        return dao.findById(id);
    }

    @Override
    public ContactCategory edit(ContactCategory contactCategory) {
        ContactCategoryDAO dao = new ContactCategoryDAO(entityManager);
        return dao.merge(contactCategory);
    }

    @Override
    public List<ContactCategory> find() {
        ContactCategoryDAO dao = new ContactCategoryDAO(entityManager);
        return dao.findAll();
    }

    @Override
    public boolean delete(ContactCategory contactCategory) {
        ContactCategoryDAO dao = new ContactCategoryDAO(entityManager);
        return dao.remove(contactCategory);
    }
}
