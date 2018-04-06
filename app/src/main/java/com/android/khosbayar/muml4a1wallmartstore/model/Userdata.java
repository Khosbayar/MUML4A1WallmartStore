package com.android.khosbayar.muml4a1wallmartstore.model;

import java.util.ArrayList;

/**
 * Created by khosbayar on 4/5/18.
 */

public class Userdata {
    static ArrayList<User> users = new ArrayList<>();

    static {
        users.add(new User("Khosbayar", "Buyandalai", "hs.khosbayar@gmail.com", "droid0304"));
        users.add(new User("Johny", "English", "johny@gmail.com", "password"));
        users.add(new User("Katy", "Perry", "katty@gmail.com", "password"));
        users.add(new User("Khosbayar", "Buyandalai", "kbuyandalai@mum.edu", "password"));
        users.add(new User("Admin", "Admin", "admin@mum.edu", "password"));
    }

    public static User findUserByUserName(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static void addUser(String fname, String lname, String username, String password) {
        users.add(new User(fname, lname, username, password));
    }

}
