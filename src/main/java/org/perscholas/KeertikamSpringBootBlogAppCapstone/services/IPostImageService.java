package org.perscholas.KeertikamSpringBootBlogAppCapstone.services;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.PostImage;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.UserPost;

import java.util.List;

public interface IPostImageService {


    void savePostImage(PostImage postimg);

    void deletePostImageById( Long imageId);

    PostImage getPostImageByUserPostId(Long postId);
}
