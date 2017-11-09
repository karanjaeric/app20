package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.Logo;

import javax.ejb.Local;
import java.util.List;

@Local
public interface LogoBeanI {

	Logo add(Logo logo);
	boolean delete(Logo logo);
	List<Logo> find();
	Logo findById(long id);
	List<Logo> findAll();
}
