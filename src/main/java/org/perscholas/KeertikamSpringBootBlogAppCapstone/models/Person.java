package org.perscholas.KeertikamSpringBootBlogAppCapstone.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;

    private String personName;

    private String email;

    private String password;

    //    One to many Mapping
    @OneToMany(cascade = CascadeType.ALL)
    private List<UserPost> userPostList = new ArrayList<>();


    // Constructors
    public Person() {
    }

    public Person(String personName) {
        this.personName = personName;
    }

    //    Parameterized constructor
    public Person(String personName, String email, String password) {
        this.personName = personName;
        this.email = email;
        this.password = password;
    }


    //  getters, and setters


    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
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

    public Long getPersonId() {
        return personId;
    }

    public List<UserPost> getUserPostList() {
        return userPostList;
    }

//    toString


    @Override
    public String toString() {
        return "Person{" +
                "userId=" + personId +
                ", userName='" + personName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
//                ", userPosts=" + userPosts +
                '}';
    }
}
