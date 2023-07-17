package org.perscholas.KeertikamSpringBootBlogAppCapstone.controller;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.PostComment;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.services.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class commentController {

    @Autowired
    private ICommentService commentService;

    public commentController(ICommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/makeComments")
    public String getAllComments(Model model) {
//fetching data from DB
        model.addAttribute("listComments", commentService.getAllComments());
        return ("/detail-post-page");
    }

    @PostMapping("/saveComment")
    public String saveComment(@ModelAttribute("postComment") PostComment postComment,
                              BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "redirect:/detail-post-page";
        }
//        Saving comments in database table
        commentService.savePostComment(postComment);
        return "redirect:/detail-post-page";
    }
}
