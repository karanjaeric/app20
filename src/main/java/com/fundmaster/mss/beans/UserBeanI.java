package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.User;
import com.fundmaster.mss.model.UserProfile;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface UserBeanI {
    User findByUsername(String username);
    User findUserByUsernameAndProfile(String username, String profile);
    User findUser(String username, String password);
    List<User> dormants(String from, String to);
    List<User> findByStatus();
    List<User> findAll(String search, int offset, int limit);
    User findBySecurityCode(String securityCode);
    User findByActivationCode(String activationCode);
    int countAll(String search);
    User find(String username, String profile);
    User findById(long id);
    User edit(User user);
    int countAdministrators(String userProfile);
}
