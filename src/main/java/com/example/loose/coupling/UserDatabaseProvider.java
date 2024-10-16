package com.example.loose.coupling;

public class UserDatabaseProvider  implements UserDataProvider{

        public String getUserDetailes(){
             return "User Details from database " ;
        }

}
