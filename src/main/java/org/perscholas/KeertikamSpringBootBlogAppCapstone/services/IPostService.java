package org.perscholas.KeertikamSpringBootBlogAppCapstone.services;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.Post;

import java.util.List;

public interface IPostService {



    void savePost(Post post);

    void deletePostById( long postId);

    List<Post> getAllPost();

    Post getPostById(long postId);
}
