package org.perscholas.KeertikamSpringBootBlogAppCapstone.models;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.UserPost;

import javax.persistence.*;

@Entity
@Table(name = "postcomments")
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private UserPost userPost;

//    default constructor

    public PostComment() {
    }

//    parameterized Constructor

    public PostComment(String content) {
        this.content = content;
    }

//    getters and setters


    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserPost getUserPost() {
        return userPost;
    }

    public void setUserPost(UserPost userPost) {
        this.userPost = userPost;
    }


//    toString

    @Override
    public String toString() {
        return "PostComment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", userPost=" + userPost +
                '}';
    }
}
