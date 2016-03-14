package com.village.rajavolu.service;

import com.village.rajavolu.dto.User;
import com.village.rajavolu.dto.UserVO;
import com.village.rajavolu.exception.RegisteredEmailException;
import com.village.rajavolu.exception.RegisteredMobileException;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Srinivas.V
 * Date: 11/15/15
 * Time: 11:01 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {

    void createUser(User user);

    List<User> findByUserEmailOrMobile(String userName,String mobileNumber);

    List<User> findByUserEmailAndPassword(String emailId, String password);

    List<User> findByUserEmail(String emailId);

    User registerUser(UserVO userVO) throws RegisteredEmailException,RegisteredMobileException;
}
