package com.village.rajavolu.util;

import com.village.rajavolu.dao.UserDao;
import com.village.rajavolu.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by sony on 27/01/2016.
 */
public class DaoTest {

    public static void main(String args[]) {

        /*ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        //List<User> userList =userDao.findByUserEmailAndPassword("vsv.valluru@gmail.com", "qwe123");
        List<User> userList =userDao.findByUserEmail("9491452162");
        System.out.println("#######user##"+userList);
        for(User user : userList){
            System.out.println("#################"+user.getEmailId() + " --- "+ user.getMobileNo());
        }*/

    }
}
