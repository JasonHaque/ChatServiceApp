package com.example.chatserviceapp.Model;

public class User {

    private String id;
    private String username;
    private String imageURL;

    public User(String id, String username, String imageURL) {
        this.id = id;
        this.username = username;
        this.imageURL = imageURL;
    }

    public User() {

    }
}
