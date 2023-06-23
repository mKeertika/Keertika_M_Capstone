package org.perscholas.KeertikamSpringBootBlogAppCapstone.models;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private LocalDate publicationDate;

    @Column
    private LocalDate postUpdateDate;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User author;


    //    Default Constructor
    public Post() {
    }

//    Getters and Setters


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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

//    toString Method

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", publicationDate=" + publicationDate +
                ", postUpdateDate=" + postUpdateDate +
                ", author=" + author +
                '}';
    }
}