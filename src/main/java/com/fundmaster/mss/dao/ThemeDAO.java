package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.Theme;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class ThemeDAO extends GenericDAOImpl<Theme, Long> {
    public ThemeDAO (EntityManager entityManager)
    {
        super(Theme.class, entityManager);
    }

    public Theme find()
    {
        List<Theme> themeList = this.findAll();
        return themeList.size() > 0 ? themeList.get(0) : null;
    }
}
