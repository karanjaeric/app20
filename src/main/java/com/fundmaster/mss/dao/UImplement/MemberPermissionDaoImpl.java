package com.fundmaster.mss.dao.UImplement;

import java.util.List;

import javax.persistence.EntityManager;

import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.dao.UInterface.MemberPermissionDao;
import com.fundmaster.mss.model.MemberPermission;

public class MemberPermissionDaoImpl extends GenericModelDaoImpl<MemberPermission> implements MemberPermissionDao{

	public MemberPermissionDaoImpl() {
		// TODO Auto-generated constructor stub
		super();
		// TODO Auto-generated constructor stub

		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}

	private EntityManager em;


	public List<MemberPermission> findAll() {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<MemberPermission> entities = em.createQuery("SELECT m FROM MemberPermission m").getResultList();
		em.close();
		return entities;
	}


	public MemberPermission findById(Long id) {
		// TODO Auto-generated method stub
		MemberPermission entity = em.find(MemberPermission.class, id);
		em.close();
		return entity;
	}

}
