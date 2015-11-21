package com.village.rajavolu.service;

import com.village.rajavolu.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 11/15/15
 * Time: 11:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context =  new ClassPathXmlApplicationContext("/spring/applicationContext.xml");

      /*ApplicationContext context = new FileSystemXmlApplicationContext("D:/programs/Git-WorkSpace/Rajavolu/src/main/resources/spring/applicationContext.xml");*/
            /*("C:/Users/ZARA/workspace/HelloSpring/src/Beans.xml");*/
        UserService userService = (UserService) context.getBean("userService");
        User user = new User();
        user.setName("Rama");
        userService.createUser(user);
    }
}
