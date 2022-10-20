package com.example.finalalbaplaceresjimenez684598endassignment.dal;

import com.example.finalalbaplaceresjimenez684598endassignment.model.User;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static List<User> users = new ArrayList<>(); // PREGUNTAR AL TÍO POR QUÉ SE UTILIZA EL STATIC

    public static List<User> getUsers() {
        return users;
    } // PREGUNTAR AL TÍO POR QUÉ SE UTILIZA EL STATIC

    public void setUsers(List<User> users) {
        Database.users = users;
    }

    public static void addUsers(){ // PREGUNTAR AL TÍO POR QUÉ SE UTILIZA EL STATIC
        users.add(new User("Alba", "user1", "password1"));
        users.add(new User("Vanessa", "user2", "password2"));
        users.add(new User("Plami", "user3", "password3"));
        users.add(new User("Motche", "user4", "password4"));
        users.add(new User("David", "user5", "password5"));
        users.add(new User("Alejandro", "user6", "password6"));
    }
}
