package org.perscholas.KeertikamSpringBootBlogAppCapstone.services;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.PostComment;

import java.util.List;

public interface ICommentService {

    List<PostComment> getAllComments();
    void savePostComment(PostComment newComment);
}
