package org.perscholas.KeertikamSpringBootBlogAppCapstone.services;

import org.apache.catalina.User;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.UserPost;

import java.util.List;

public interface IPostService {


    void savePost(UserPost userPost);

    void deletePostById( Long postId);

    List<UserPost> getAllUserPost();

    UserPost getPostById(Long postId);

    Object getAllPost();
}
