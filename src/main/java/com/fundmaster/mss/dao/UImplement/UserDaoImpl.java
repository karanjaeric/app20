package com.fundmaster.mss.dao.UImplement;

import java.util.List;

import javax.persistence.EntityManager;

import com.fundmaster.mss.common.EntityManagerFactoryHelper;
import com.fundmaster.mss.dao.UInterface.UserDao;
import com.fundmaster.mss.model.User;

public class UserDaoImpl extends GenericModelDaoImpl<User> implements UserDao {

	private EntityManager em;

	public UserDaoImpl() {
		super();
		// TODO Auto-generated constructor stub

		this.em = EntityManagerFactoryHelper.getFactory().createEntityManager();
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<User> entities = em.createQuery("SELECT u FROM User u").getResultList();
		em.close();
		return entities;
	}

	@SuppressWarnings("unchecked")
	public User findByUsername(String username)
	{
		// TODO Auto-generated method stub
		List<User> results = em.createQuery("SELECT u FROM User u WHERE u.username=:username").setParameter("username", username).getResultList();
		em.close();
		if (results.isEmpty()) {

            return null;

         }  else {

            return results.get(0);

         }
	}

	@SuppressWarnings("unchecked")
	public User findUserByUsernameAndProfile(String username, String profile)
	{
		// TODO Auto-generated method stub
		List<User> results = em.createQuery("SELECT u FROM User u WHERE u.username=:username and u.userProfile=:profile").setParameter("username", username)

                .setParameter("profile", profile).getResultList();
		em.close();
		if (results.isEmpty()) {

            return null;

         }  else {

            return results.get(0);

         }
	}

	@SuppressWarnings("unchecked")
	public User findUser(String username, String password)
	{
		// TODO Auto-generated method stub
		/* 1. The email address should not be case sensitive while registering or login to Mss. */
		List<User> results = em.createQuery("SELECT u FROM User u WHERE LOWER(u.username)=:username and u.password=:password").setParameter("username", username.toLowerCase())

                .setParameter("password", password).getResultList();
		em.close();
		if (results.isEmpty()) {

            return null;

         } else if (results.size() > 1) {

            throw new IllegalStateException(

                  "Cannot have more than one user with the same username!");

         } else {

            return results.get(0);

         }
	}

	
	public List<User> dormants(String from, String to) {
		// TODO Auto-generated method stub
		String query_string = "SELECT a FROM User a WHERE  username NOT IN (SELECT a.username FROM AuditTrail WHERE DATE(datetime) >= '" + from + "' AND DATE(datetime) <= '" + to + "')";
		@SuppressWarnings("unchecked")
		List<User> entities = em.createQuery(query_string)
		         .getResultList();
		em.close();
		return entities;
	}

	public List<User> findByStatus(int status) {
		// TODO Auto-generated method stub
		String query_string = "SELECT u FROM User u WHERE status = " + status + " order by u.id asc";
		@SuppressWarnings("unchecked")
		List<User> entities = em.createQuery(query_string)
		         .getResultList();
		em.close();
		return entities;
	}

	public List<User> findAll(String search, int offset, int limit) {
		// TODO Auto-generated method stub
		String query_string;
		if(search != null)
			query_string = "SELECT u FROM User u WHERE username like '%" + search + "%' order by u.id asc";
		else
			query_string = "SELECT u FROM User u order by u.id asc";
		@SuppressWarnings("unchecked")
		List<User> entities = em.createQuery(query_string)
		         .setFirstResult(offset) 
		         .setMaxResults(limit)
		         .getResultList();
		em.close();
		return entities;
	}
	@SuppressWarnings("unchecked")
	public User findBySecurityCode(String securityCode)
	{
		// TODO Auto-generated method stub
				List<User> results = em.createQuery("SELECT u FROM User u WHERE u.securityCode=:securityCode").setParameter("securityCode", securityCode).getResultList();
				em.close();
				if (results.isEmpty()) {

		            return null;

		         } else {

		            return results.get(0);

		         }
	}
	@SuppressWarnings("unchecked")
	public int countAll(String search)
	{
		List<User> users = null;
		String query_string;
		if(search != null)
			query_string = "SELECT u FROM User u WHERE username like '%" + search + "%'";
		
		else

			query_string = "SELECT u FROM User u";
		users = em.createQuery(query_string).getResultList();
		return users.size();
	}
	@SuppressWarnings("unchecked")
	public User find(String username, String profile)
	{
		// TODO Auto-generated method stub
		List<User> results = em.createQuery("SELECT u FROM User u WHERE u.username=:username and u.userProfile=:profile").setParameter("username", username)

                .setParameter("profile", profile).getResultList();
		em.close();
		if (results.isEmpty()) {

            return null;

         } else {

            return results.get(0);

         }
	}
	public User findById(Long id) {
		// TODO Auto-generated method stub
		User entity = em.find(User.class, id);
		em.close();
		return entity;
	}

}
