package org.perscholas.KeertikamSpringBootBlogAppCapstone.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Author")
public class String {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private java.lang.String username;

    private java.lang.String email;

    private java.lang.String password;

    // Constructors

    public String() {
    }

//    Parameterized constructor
    public String(java.lang.String username, java.lang.String email, java.lang.String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }


//    One to many Mapping
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Post> posts =new ArrayList<>();


    //  getters, and setters


    public java.lang.String getUsername() {
        return username;
    }

    public void setUsername(java.lang.String username) {
        this.username = username;
    }

    public java.lang.String getEmail() {
        return email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public java.lang.String getPassword() {
        return password;
    }

    public void setPassword(java.lang.String password) {
        this.password = password;
    }

//    toString

    @Override
    public java.lang.String toString() {
        return "String{" +
                "id=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
