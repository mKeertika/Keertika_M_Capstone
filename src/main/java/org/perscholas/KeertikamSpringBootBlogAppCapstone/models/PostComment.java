package org.perscholas.KeertikamSpringBootBlogAppCapstone.models;

import javax.persistence.*;

@Entity
@Table(name = "postcomments")
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

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


    public Long getCommentId() {
        return commentId;
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
                "id=" + commentId +
                ", content='" + content + '\'' +
                ", userPost=" + userPost +
                '}';
    }
}
