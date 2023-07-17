package org.perscholas.KeertikamSpringBootBlogAppCapstone.services;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.PostComment;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.repositories.ICommentRepository;
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


    @Override
    public void savePostComment(PostComment newComment) {
        commentRepository.save(newComment);
    }

//
//    public PostComment getByCommentId(Long commentId) {
//
//            Optional<PostComment> optionalComment = commentRepository.findById(commentId);
//            if (optionalComment.isPresent()) {
//                PostComment newComment = optionalComment.get();
//                return newComment;
//            }
//            throw new PostNotFoundException();
//        }

}
