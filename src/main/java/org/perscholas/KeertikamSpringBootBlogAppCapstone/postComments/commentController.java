package org.perscholas.KeertikamSpringBootBlogAppCapstone.postComments;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.PostComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class commentController {

    @Autowired
    private ICommentService commentService;

    public commentController(ICommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comments")
    public String showComments(Model model) {
        List<PostComment> comments = commentService.getAllComments();
        model.addAttribute("comments", comments);
        return "comments";
    }
}
