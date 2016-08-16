package com.fundmaster.mss.beans;

import java.util.List;

import javax.ejb.Local;

import com.fundmaster.mss.model.Logo;

@Local
public interface LogoBeanI {

	Logo add(Logo logo);
	boolean delete(Logo logo);
	List<Logo> find();
	Logo findById(long id);
	List<Logo> findAll();
}
