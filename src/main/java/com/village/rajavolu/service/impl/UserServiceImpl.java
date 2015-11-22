package com.village.rajavolu.service.impl;

import com.village.rajavolu.dao.UserDao;
import com.village.rajavolu.dto.User;
import com.village.rajavolu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: user
 * Date: 11/15/15
 * Time: 11:01 PM
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional(value = "rajavoluTransactionManager", propagation = Propagation.REQUIRED)
    public void createUser(User user) {
        userDao.create(user);
    }
}
