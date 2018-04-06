package com.android.khosbayar.muml4a1wallmartstore.model;

/**
 * Created by khosbayar on 4/4/18.
 */

public class User {
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public User(String fname, String lname, String username, String password) {
        this.username = username;
        this.password = password;
        firstName = fname;
        lastName = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
