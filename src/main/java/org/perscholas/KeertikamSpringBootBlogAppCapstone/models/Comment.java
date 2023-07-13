//package org.perscholas.KeertikamSpringBootBlogAppCapstone.models;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//public class Comment {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String commentText;
//
//    @Column(nullable = false)
//    private LocalDateTime timestamp;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "blog_post_id", nullable = false)
//    private UserPost userPost;
//
//}
