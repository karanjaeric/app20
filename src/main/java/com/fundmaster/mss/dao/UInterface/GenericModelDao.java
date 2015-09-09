package com.fundmaster.mss.dao.UInterface;

import javax.ejb.Local;

@Local
public interface GenericModelDao<T> {

	public void persist(T entity);
	
	public void update(T entity);
	
	public void delete(T entity);
	
}
