package org.perscholas.KeertikamSpringBootBlogAppCapstone.postComments;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.PostComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class commentServiceImpl implements ICommentService {

    private ICommentRepository commentRepository;

    @Autowired
    public commentServiceImpl(ICommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<PostComment> getAllComments() {
        return commentRepository.findAll();
    }
}
