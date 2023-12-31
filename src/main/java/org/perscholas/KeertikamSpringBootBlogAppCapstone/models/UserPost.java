package org.perscholas.KeertikamSpringBootBlogAppCapstone.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "userpost")
public class UserPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String postTitle;

    private String content;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate publicationDate;

    private String author;

//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private Person user;


    //    Default Constructor
    public UserPost() {
    }
//parameterized constructor

    public UserPost(String postTitle, String content, LocalDate publicationDate, String author) {
        this.postTitle = postTitle;
        this.content = content;
        this.publicationDate = publicationDate;
        this.author = author;
    }


//    Getters and Setters


    public void setPostId(Long postId) {
        this.postId = postId;
    }
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
//    toString Method


    @Override
    public String toString() {
        return "UserPost{" +
                "postTitle='" + postTitle + '\'' +
                ", content='" + content + '\'' +
                ", publicationDate=" + publicationDate +
                ", author='" + author + '\'' +
                '}';
    }
}