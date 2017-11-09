package com.fundmaster.mss.beans;

import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.LogoDAO;
import com.fundmaster.mss.model.Logo;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Local
@Stateless
public class LogoBean implements LogoBeanI {

	 @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
	    private EntityManager entityManager;

	    @Override
	    public Logo add(Logo logo) {
	    	LogoDAO dao = new LogoDAO(entityManager);
	        return dao.update(logo);
	    }
	    
	    @Override
	    public List<Logo> findAll() {
	    	LogoDAO dao = new LogoDAO(entityManager);
	    	return dao.findAll();
	    }

	    @Override
	    public Logo findById(long id) {
	        LogoDAO dao = new LogoDAO(entityManager);
	        return dao.findById(id);
	    }

	    @Override
	    public boolean delete(Logo logo) {
	        LogoDAO dao = new LogoDAO(entityManager);
	        return dao.remove(logo);
	    }

	    @Override
	    public List<Logo> find() {
	        LogoDAO dao = new LogoDAO(entityManager);
	        return dao.findAll();
	    }
}
