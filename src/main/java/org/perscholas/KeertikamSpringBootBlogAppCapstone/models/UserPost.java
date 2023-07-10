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

    private LocalDate postUpdateDate;

    private String author;


    //    Default Constructor
    public UserPost() {
    }
//parameterized constructor


    public UserPost(String postTitle, String content, LocalDate publicationDate, LocalDate postUpdateDate, String author) {
        this.postTitle = postTitle;
        this.content = content;
        this.publicationDate = publicationDate;
        this.postUpdateDate = postUpdateDate;
        this.author = author;
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
        return "UserPost{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", content='" + content + '\'' +
                ", publicationDate=" + publicationDate +
                ", postUpdateDate=" + postUpdateDate +
                ", author='" + author + '\'' +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UserPost userPost = (UserPost) o;
//        return postId == userPost.postId && Objects.equals(postTitle, userPost.postTitle) && Objects.equals(content, userPost.content)
//                && Objects.equals(publicationDate, userPost.publicationDate)&& Objects.equals(author, userPost.author);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPost userPost = (UserPost) o;
        return Objects.equals(postTitle, userPost.postTitle) && Objects.equals(content, userPost.content) && Objects.equals(author, userPost.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postTitle, content, author);
    }
}