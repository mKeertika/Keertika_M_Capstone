package org.perscholas.KeertikamSpringBootBlogAppCapstone.models;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String title;

    private String content;

    private LocalDate publicationDate;

    private LocalDate postUpdateDate;

    private String author;


    //    Default Constructor
    public Post() {
    }
//parameterized constructor

    public Post(String title, String content, LocalDate publicationDate, LocalDate postUpdateDate, String author) {
        this.title = title;
        this.content = content;
        this.publicationDate = publicationDate;
        this.postUpdateDate = postUpdateDate;
        this.author = author;
    }


    //    Getters and Setters
    public Long getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public LocalDate getPostUpdateDate() {
        return postUpdateDate;
    }

    public void setPostUpdateDate(LocalDate postUpdateDate) {
        this.postUpdateDate = postUpdateDate;
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
        return "Post{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", publicationDate=" + publicationDate +
                ", postUpdateDate=" + postUpdateDate +
                ", author='" + author + '\'' +
                '}';
    }
}