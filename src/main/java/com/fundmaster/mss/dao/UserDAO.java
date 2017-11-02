package com.fundmaster.mss.dao;

import com.fundmaster.mss.model.User;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by bryanitur on 1/29/2016.
 */
public class UserDAO extends GenericDAOImpl<User, Long> {
    private final EntityManager em;
    public UserDAO(EntityManager entityManager)
    {
        super(User.class, entityManager);
        em = entityManager;
    }



    @SuppressWarnings("unchecked")
    public User findByUsername(String username)
    {
        // TODO Auto-generated method stub
        List<User> results = em.createQuery("SELECT u FROM User u WHERE u.username=:username").setParameter("username", username).getResultList();

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

        if (results.isEmpty()) {

            return null;

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

        return entities;
    }

    public List<User> findByStatus() {
        // TODO Auto-generated method stub
        String query_string = "SELECT u FROM User u WHERE status = " + 0 + " order by u.id asc";
        @SuppressWarnings("unchecked")
        List<User> entities = em.createQuery(query_string)
                .getResultList();

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

        return entities;
    }
    @SuppressWarnings("unchecked")
    public User findBySecurityCode(String securityCode)
    {
        // TODO Auto-generated method stub
        List<User> results = em.createQuery("SELECT u FROM User u WHERE u.securityCode=:securityCode").setParameter("securityCode", securityCode).getResultList();

        if (results.isEmpty()) {

            return null;

        } else {

            return results.get(0);

        }
    }

    public User findByActivationCode(String activationCode){
        List<User> results = em.createQuery("SELECT u FROM User u WHERE u.smsActivationCode=:activationCode").setParameter("activationCode", activationCode).getResultList();

        if (results.isEmpty()) {

            return null;

        } else {

            return results.get(0);

        }
    }
    @SuppressWarnings("unchecked")
    public int countAll(String search)
    {
        List<User> users;
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

        if (results.isEmpty()) {

            return null;

        } else {

            return results.get(0);

        }
    }
}
