package org.perscholas.KeertikamSpringBootBlogAppCapstone.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
public class UserPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String postTitle;

    private String content;

    private LocalDate publicationDate;

    private String author;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    //    Default Constructor
    public UserPost() {
    }
//parameterized constructor

    public UserPost(String postTitle, String content, LocalDate publicationDate, String author, User user) {
        this.postTitle = postTitle;
        this.content = content;
        this.publicationDate = publicationDate;
        this.author = author;
        this.user = user;
    }



    //    Getters and Setters

    public Long getPostId() {
        return postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public User getUser() {
        return user;
    }


//    toString Method

    @Override
    public String toString() {
        return "UserPost{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", content='" + content + '\'' +
                ", publicationDate=" + publicationDate +
                ", author='" + author + '\'' +
                '}';
    }

}