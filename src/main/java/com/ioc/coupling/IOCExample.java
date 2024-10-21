package com.ioc.coupling;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class IOCExample {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationDataIOC.xml");
        /////////////////////////////////////////////////////////
        //this code was optimizes by IOC Design Pattren

//        UserDataProvider dataProvider = new UserDatabaseProvider();
//        com.example.loose.coupling.UserManager userManagerWithDB = new com.example.loose.coupling.UserManager(dataProvider);
//        System.out.println(userManagerWithDB.getUserInfo());

        // insted of we creating a obj (direct dependency ) spring will take care as we have created a bean
        UserManager userManagerWithDB = (UserManager) context.getBean("userManagerUserDatabaseProvider");
        System.out.println(userManagerWithDB.getUserInfo());

        UserManager userManagerWithWS = (UserManager) context.getBean("userManagerWebServerDataProvider");
        System.out.println(userManagerWithWS.getUserInfo());

    }


}
