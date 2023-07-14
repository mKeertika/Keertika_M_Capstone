package org.perscholas.KeertikamSpringBootBlogAppCapstone.postComments;

import javax.xml.stream.events.Comment;
import java.util.Comparator;
import java.util.List;

public interface ICommentService {

    List<PostComment> getAllComments();
}
