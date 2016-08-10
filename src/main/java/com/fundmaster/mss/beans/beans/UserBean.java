package com.fundmaster.mss.beans.beans;

import com.fundmaster.mss.beans.ejb.UserEJB;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.common.JLogger;
import com.fundmaster.mss.dao.UserDAO;
import com.fundmaster.mss.model.Help;
import com.fundmaster.mss.model.User;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
@Stateless
public class UserBean implements UserEJB {
    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;
    JLogger jLogger = new JLogger(this.getClass());
    Helper helper = new Helper();
    @Override
    public User findByUsername(String username) {
        UserDAO dao = new UserDAO(entityManager);
        return dao.findByUsername(username);
    }

    @Override
    public User findUserByUsernameAndProfile(String username, String profile) {
        UserDAO dao = new UserDAO(entityManager);
        return dao.findUserByUsernameAndProfile(username, profile);
    }

    @Override
    public User findUser(String username, String password) {
        UserDAO dao = new UserDAO(entityManager);
        password = helper.encrypt(password);
        jLogger.i("Username is : " + username + ", Password is: " + password);
        return dao.findUser(username, password);
    }

    @Override
    public User findById(long id) {
        UserDAO dao = new UserDAO(entityManager);
        return dao.findById(id);
    }

    @Override
    public List<User> dormants(String from, String to) {
        UserDAO dao = new UserDAO(entityManager);
        return dao.dormants(from, to);
    }

    @Override
    public User edit(User user) {

        UserDAO dao = new UserDAO(entityManager);
        return dao.merge(user);
    }

    @Override
    public List<User> findByStatus() {
        UserDAO dao = new UserDAO(entityManager);
        return dao.findByStatus();
    }

    @Override
    public List<User> findAll(String search, int offset, int limit) {
        UserDAO dao = new UserDAO(entityManager);
        return dao.findAll();
    }

    @Override
    public User findBySecurityCode(String securityCode) {
        UserDAO dao = new UserDAO(entityManager);
        return dao.findBySecurityCode(securityCode);
    }

    @Override
    public int countAll(String search) {
        UserDAO dao = new UserDAO(entityManager);
        return dao.countAll(search);
    }

    @Override
    public User find(String username, String profile) {
        UserDAO dao = new UserDAO(entityManager);
        return dao.find(username, profile);
    }
}
