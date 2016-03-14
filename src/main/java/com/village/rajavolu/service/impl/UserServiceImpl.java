package com.village.rajavolu.service.impl;

import com.village.rajavolu.dao.UserDao;
import com.village.rajavolu.dto.User;
import com.village.rajavolu.dto.UserVO;
import com.village.rajavolu.exception.RegisteredEmailException;
import com.village.rajavolu.exception.RegisteredMobileException;
import com.village.rajavolu.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: Srinivas.V
 * Date: 11/15/15
 * Time: 11:01 PM
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
    @Autowired
    UserDao userDao;

    @Transactional(value = "rajavoluTransactionManager", propagation = Propagation.REQUIRED)
    public void createUser(User user) {
        userDao.create(user);
    }

    @Override
    public List<User> findByUserEmailOrMobile(String userName, String mobileNumber) {
        return userDao.findByEmailOrMobileNo(userName, mobileNumber);
    }

    @Override
    public List<User> findByUserEmailAndPassword(String emailId, String password){
        return userDao.findByUserEmailAndPassword(emailId,password);
    }

    @Override
    public List<User> findByUserEmail(String emailId){
        return userDao.findByUserEmail(emailId);
    }

    @Transactional(value = "rajavoluTransactionManager", propagation = Propagation.REQUIRED)
    public User registerUser(UserVO userVO) throws RegisteredEmailException , RegisteredMobileException{
        User existingUser = null;
        List<User> users = userDao.findByEmailOrMobileNo(userVO.getEmailId(), userVO.getMobileNo());
        if (users != null && !users.isEmpty()) {
            for (User oldUser : users) {
                if (oldUser.getEmailId().equalsIgnoreCase(userVO.getEmailId())) {
                    existingUser = oldUser;
                } else if (oldUser.getMobileNo().equalsIgnoreCase(userVO.getMobileNo())) {
                    existingUser = oldUser;
                }
            }
        }
        if (null != existingUser) {
            if (existingUser.getEmailId().equalsIgnoreCase(userVO.getEmailId())) {
                final String errorMessage = "User already existing this email " + existingUser.getEmailId();
                throw new RegisteredEmailException(errorMessage);
            } else if (existingUser.getMobileNo().equalsIgnoreCase(userVO.getMobileNo())) {
                final String errorMessage = "User already existing this mobile " + existingUser.getMobileNo();
                throw new RegisteredMobileException(errorMessage);
            }
        }
        User user = new User();
        user.setFirstName(userVO.getFirstName());
        user.setLastName(userVO.getLastName());
        user.setEmailId(userVO.getEmailId());
        user.setPassword(userVO.getPassword());
        user.setConfirmPassword(userVO.getConfirmPassword());
        user.setDateOfBirth(userVO.getDateOfBirth());
        user.setMobileNo(userVO.getMobileNo());
        user.setAadharNo(userVO.getAadharNo());
        user.setPinCode(userVO.getPinCode());
        userDao.create(user);
        //TODO we need to send a customer registration mail.
        return user;
    }

}
