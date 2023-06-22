package org.perscholas.KeertikamSpringBootBlogAppCapstone.modelsphase2;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.Post;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String content;

    @Column
    private LocalDateTime creationDateTime;

    @Column
    private User author;

    @Column
    private Post post;


//    Default Constructor
    public Comment() {
    }

//    Getters & Setters


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

//    toString method

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", creationDateTime=" + creationDateTime +
                ", author=" + author +
                ", post=" + post +
                '}';
    }
}
