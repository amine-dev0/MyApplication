package com.example.myapplication;

import android.graphics.Bitmap;

public class ModelClass {

    private String username, email, age, password;
    private Bitmap profileImage;


    public ModelClass(String username, String email, String age, String password, Bitmap profileImage) {
        this.username = username;
        this.email = email;
        this.age = age;
        this.password = password;
        this.profileImage = profileImage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Bitmap getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Bitmap profileImage) {
        this.profileImage = profileImage;
    }
}
