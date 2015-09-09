package com.fundmaster.mss.dao.UImplement;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.fundmaster.mss.common.Common;
import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.dao.UInterface.ActivityLogDao;
import com.fundmaster.mss.model.ActivityLog;
import com.fundmaster.mss.model.PieObject;

public class ActivityLogDaoImpl extends GenericModelDaoImpl<ActivityLog> implements ActivityLogDao{

	private EntityManager em;

	public ActivityLogDaoImpl() {
		super();
		// TODO Auto-generated constructor stub

		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}

	public List<ActivityLog> findAllByUserID(String user_id) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<ActivityLog> logs = em.createQuery("SELECT a FROM ActivityLog a WHERE user_id=:user_id order by a.id desc").setParameter("user_id", user_id).setMaxResults(10).getResultList();
		em.close();
		return logs;
	}

	public List<ActivityLog> findAll() {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<ActivityLog> entities = em.createQuery("SELECT a FROM ActivityLog a").getResultList();
		em.close();
		return entities;
	}

	@SuppressWarnings("unchecked")
	public List<PieObject> findByFrontPageAccess()
	{
		List<Object[]> results = em.createQuery("SELECT a.access_menu AS access_menu, COUNT(access_menu) AS total FROM ActivityLog a WHERE access_menu != '' and access_menu IN ('" + Common.PAGE_HOME + "', '" + Common.PAGE_REGISTER + "', '" + Common.PAGE_CONTACT_US + "', '" + Common.PAGE_INTEREST_RATES + "', '" + Common.PAGE_WHAT_IF_ANALYSIS + "') GROUP BY a.access_menu").getResultList();
		List<PieObject> poList = new ArrayList<PieObject>();
		for (Object[] result : results) {
			
			PieObject po = new PieObject(result[0].toString(), Double.parseDouble(result[1].toString()));
		    
			poList.add(po);
		}
		return poList;
	}

	@SuppressWarnings("unchecked")
	public List<PieObject> findAccessByProfile()
	{
		List<Object[]> results = em.createQuery("SELECT a.userProfile AS userProfile, COUNT(userProfile) AS total FROM ActivityLog a WHERE userProfile != NULL GROUP BY a.userProfile").getResultList();
		List<PieObject> poList = new ArrayList<PieObject>();
		for (Object[] result : results) {
			
			PieObject po = new PieObject(result[0].toString(), Double.parseDouble(result[1].toString()));
		    
			poList.add(po);
		}
		return poList;
	}

	@SuppressWarnings("unchecked")
	public List<PieObject> mostAccessedByMembers()
	{
		List<Object[]> results = em.createQuery("SELECT a.access_menu AS access_menu, COUNT(access_menu) AS total FROM ActivityLog a WHERE userProfile ='" + Common.MEMBER_PROFILE + "' AND access_menu != NULL AND scheme != NULL GROUP BY a.access_menu").setMaxResults(5).getResultList();
		List<PieObject> poList = new ArrayList<PieObject>();
		for (Object[] result : results) {
			
			PieObject po = new PieObject(result[0].toString(), Double.parseDouble(result[1].toString()));
		    
			poList.add(po);
		}
		return poList;
	}

	@SuppressWarnings("unchecked")
	public List<PieObject> mostAccessedByManagers()
	{
		List<Object[]> results = em.createQuery("SELECT a.access_menu AS access_menu, COUNT(access_menu) AS total FROM ActivityLog a WHERE userProfile !='" + Common.MEMBER_PROFILE + "' AND access_menu != '' AND access_menu != '" + Common.PAGE_LOGIN + "' AND userProfile != NULL  GROUP BY a.access_menu").setMaxResults(5).getResultList();
		List<PieObject> poList = new ArrayList<PieObject>();
		for (Object[] result : results) {
			
			PieObject po = new PieObject(result[0].toString(), Double.parseDouble(result[1].toString()));
		    
			poList.add(po);
		}
		return poList;
	}

	public ActivityLog findById(Long id) {
		// TODO Auto-generated method stub
		ActivityLog entity = em.find(ActivityLog.class, id);
		em.close();
		return entity;
	}
	
}
