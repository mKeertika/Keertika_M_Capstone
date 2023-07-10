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

    // Constructors

    public User() {
    }

//    Parameterized constructor
    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }


//    One to many Mapping
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<UserPost> userPosts =new ArrayList<>();


    //  getters, and setters


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
    //    toString

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", username='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
