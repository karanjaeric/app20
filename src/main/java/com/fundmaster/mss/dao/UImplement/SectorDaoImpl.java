package com.fundmaster.mss.dao.UImplement;

import java.util.List;

import javax.persistence.EntityManager;

import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.dao.UInterface.SectorDao;
import com.fundmaster.mss.model.Sector;

public class SectorDaoImpl extends GenericModelDaoImpl<Sector> implements SectorDao{

	private EntityManager em;

	public SectorDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}

	public List<Sector> findAll() {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<Sector> entities = em.createQuery("SELECT s FROM Sector s").getResultList();
		em.close();
		return entities;
	}

	public Sector findById(Long id) {
		// TODO Auto-generated method stub
		Sector entity = em.find(Sector.class, id);
		return entity;
	}

}
