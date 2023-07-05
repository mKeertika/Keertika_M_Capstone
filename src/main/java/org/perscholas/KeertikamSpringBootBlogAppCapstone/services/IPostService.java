package org.perscholas.KeertikamSpringBootBlogAppCapstone.services;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.UserPost;

import java.util.List;

public interface IPostService {



    void savePost(UserPost userPost);

    void deletePostById( long postId);

    List<UserPost> getAllPost();

    UserPost getPostById(long postId);
}
