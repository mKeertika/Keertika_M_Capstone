package org.perscholas.KeertikamSpringBootBlogAppCapstone.models;


import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.UserPost;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;

    private String email;

    private String password;

    //    One to many Mapping
    @OneToMany(cascade = CascadeType.ALL)
    private List<UserPost> userPostList = new ArrayList<>();


    // Constructors
    public User() {
    }

    //    Parameterized constructor
    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }


    //  getters, and setters


    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public List<UserPost> getUserPostList() {
        return userPostList;
    }

//    toString


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
//                ", userPosts=" + userPosts +
                '}';
    }
}
