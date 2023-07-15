package org.perscholas.KeertikamSpringBootBlogAppCapstone.postComments;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.PostComment;

import java.util.List;

public interface ICommentService {

    List<PostComment> getAllComments();
}
