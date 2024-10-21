package com.ioc.coupling;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class IOCExample {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationDataIOC.xml");

        UserManager userManagerWithDB = (UserManager) context.getBean("userManagerUserDatabaseProvider");
        System.out.println(userManagerWithDB.getUserInfo());

        UserManager userManagerWithWS = (UserManager) context.getBean("userManagerWebServerDataProvider");
        System.out.println(userManagerWithWS.getUserInfo());

    }


}
