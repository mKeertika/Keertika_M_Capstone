package org.perscholas.KeertikamSpringBootBlogAppCapstone.models;

import javax.persistence.*;

public class PostImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    @Column(nullable = false)
    private String imageName;

    @Column(nullable = false)
    private String filePath;


    @JoinColumn(name = "blog_post_id", nullable = false)
    private UserPost userPost;

//    default constructor
        public PostImage() {
    }


}
