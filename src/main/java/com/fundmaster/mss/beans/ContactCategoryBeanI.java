package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.ContactCategory;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface ContactCategoryBeanI {

    ContactCategory add(ContactCategory contactCategory);
    ContactCategory edit(ContactCategory contactCategory);
    List<ContactCategory> find();
    boolean delete(ContactCategory contactCategory);
    ContactCategory findById(long id);

}
