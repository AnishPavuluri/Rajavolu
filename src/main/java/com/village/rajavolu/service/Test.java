package com.village.rajavolu.service;

import com.village.rajavolu.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 11/15/15
 * Time: 11:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public static void main(String[] args) throws Exception{
        ApplicationContext context =  new ClassPathXmlApplicationContext("/spring/applicationContext.xml");

      /*ApplicationContext context = new FileSystemXmlApplicationContext("D:/programs/Git-WorkSpace/Rajavolu/src/main/resources/spring/applicationContext.xml");*/
            /*("C:/Users/ZARA/workspace/HelloSpring/src/Beans.xml");*/
        UserService userService = (UserService) context.getBean("userService");
        User user = new User();
        user.setFirstName("Anish");
       // user.setName("Rama");
        userService.createUser(user);

        /*Class.forName("com.mysql.jdbc.Driver").newInstance();
               String cs="jdbc:mysql://localhost:3306/test";
               String user="root";
               String password="root";
               Connection con= DriverManager.getConnection(cs, user, password);
               if(con==null)
               {
               System.out.println("connection not established");
               }
               else
               {
            	   System.out.println(con);
               DatabaseMetaData db=con.getMetaData();
               System.out.println("db===========>"+db.getDatabaseProductName());
               }*/


    }
}
