package com.village.rajavolu.dao;

import com.village.rajavolu.dto.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Srinivas.V
 * Date: 4/21/14
 * Time: 3:12 AM
 */
public interface UserDao extends GenericDao<User, Long > {

    List<User> findByEmailOrMobileNo(String name,String mobile);

    List<User> findByUserMobileNo(String mobileNo);

    List<User> findByUserEmail(String emailId);

}
