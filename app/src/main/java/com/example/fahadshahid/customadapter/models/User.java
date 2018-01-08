package com.example.fahadshahid.customadapter.models;

/**
 * Created by Fahad Shahid on 9/28/2017.
 */

public class User {
    private int id;
    private String username;
    private String password;
    private String rollnumber;
    private String fullname;

    public User(int id, String username, String password, String rollnumber, String fullname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.rollnumber = rollnumber;
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rollnumber='" + rollnumber + '\'' +
                ", fullname='" + fullname + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(String rollnumber) {
        this.rollnumber = rollnumber;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
