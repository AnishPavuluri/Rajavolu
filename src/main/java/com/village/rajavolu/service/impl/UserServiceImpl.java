package com.village.rajavolu.service.impl;

import com.village.rajavolu.dao.UserDao;
import com.village.rajavolu.dto.User;
import com.village.rajavolu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: user
 * Date: 11/15/15
 * Time: 11:01 PM
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void createUser(User user) {
        userDao.create(user);
    }
}
