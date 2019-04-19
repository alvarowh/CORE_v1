package com.example.core_v1.utils;

import com.example.core_v1.entities.user;

import java.util.HashMap;

public class AutoLoader {

    public AutoLoader() {
    }
    public void autouserload(HashMap<Integer, user> MapUsers) {

        MapUsers.put(1,new user(1,"Alvaro","1111"));
        MapUsers.put(2,new user(2,"Peter","9324"));
        MapUsers.put(3,new user(3,"Mei","9ab3"));
        MapUsers.put(4,new user(4,"Andy","432f"));
        MapUsers.put(5,new user(5,"Jordan","gdg3"));
        MapUsers.put(6,new user(6,"Ellie","322d"));

    }


    public void userload(HashMap<Integer, user> MapUsers, String log_name, String log_pass) {

        int id = MapUsers.size()+1;
        MapUsers.put(id,new user(id,log_name,log_pass));
    }
}
