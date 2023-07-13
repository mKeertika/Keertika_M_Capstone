//package org.perscholas.KeertikamSpringBootBlogAppCapstone.models;
//
//import javax.persistence.*;
//
//@Entity
//public class PostImage {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long imageId;
//
//    @Column(nullable = false)
//    private String imageName;
//
//    @Column(nullable = false)
//    private String filePath;
//
//    @OneToOne
//    @JoinColumn(name = "blog_post_id", nullable = false)
//    private UserPost userPost;
//
////    default constructor
//        public PostImage() {
//    }
//
//    public PostImage(String imageName, String filePath) {
//        this.imageName = imageName;
//        this.filePath = filePath;
//    }
//
//
////    getters and setters
//
//
//    public Long getImageId() {
//        return imageId;
//    }
//
//    public String getImageName() {
//        return imageName;
//    }
//
//    public void setImageName(String imageName) {
//        this.imageName = imageName;
//    }
//
//    public String getFilePath() {
//        return filePath;
//    }
//
//    public void setFilePath(String filePath) {
//        this.filePath = filePath;
//    }
//
//    public UserPost getUserPost() {
//        return userPost;
//    }
//
//
////    toString method
//
//
//    @Override
//    public String toString() {
//        return "PostImage{" +
//                "imageId=" + imageId +
//                ", imageName='" + imageName + '\'' +
//                ", filePath='" + filePath + '\'' +
//                ", userPost=" + userPost +
//                '}';
//    }
//}
