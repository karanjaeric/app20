package com.fundmaster.mss.dao.UImplement;

import java.util.List;

import javax.persistence.EntityManager;

import com.fundmaster.mss.dao.UInterface.UsedPasswordDao;
import com.fundmaster.mss.model.UsedPassword;

public class UsedPasswordDaoImpl extends GenericModelDaoImpl<UsedPassword> implements UsedPasswordDao{

	private EntityManager em;

	public UsedPasswordDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean isUsed(String password)
	{
		@SuppressWarnings("unchecked")
		List<UsedPassword> usedPassword = em.createQuery("SELECT u FROM UsedPassword WHERE password:password").setParameter("password", password).getResultList();
		if(usedPassword != null && usedPassword.size() > 0)
			return true;
		else
			return false;
	}
	
}
