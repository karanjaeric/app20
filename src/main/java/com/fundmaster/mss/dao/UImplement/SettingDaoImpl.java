package com.fundmaster.mss.dao.UImplement;

import java.util.List;

import javax.persistence.EntityManager;

import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.dao.UInterface.SettingDao;
import com.fundmaster.mss.model.Setting;

public class SettingDaoImpl extends GenericModelDaoImpl<Setting> implements SettingDao{

	private EntityManager em;

	public SettingDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}

	public List<Setting> findAll() {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<Setting> entities = em.createQuery("SELECT s FROM Setting s").getResultList();
		em.close();
		return entities;
	}


	public Setting findById(Long id) {
		// TODO Auto-generated method stub
		Setting entity = em.find(Setting.class, id);
		em.close();
		return entity;
	}
}
