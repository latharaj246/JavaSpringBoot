package com.example.loose.coupling;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class LooseCouplingExample {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationDataProvider.xml");


        UserDataProvider dataProvider = new UserDatabaseProvider();
        UserManager userManagerWithDB = new UserManager(dataProvider);
        System.out.println(userManagerWithDB.getUserInfo());

        WebServerDataProvider webServerDataProvider = new WebServerDataProvider();
        UserManager userManagerWithWS = new UserManager(webServerDataProvider);
        System.out.println(userManagerWithWS.getUserInfo());


    }


}
