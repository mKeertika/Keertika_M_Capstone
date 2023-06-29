package org.perscholas.KeertikamSpringBootBlogAppCapstone.controller;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PostController {

    private IPostService postService;

//    Constructor

    @Autowired
    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @GetMapping("/detail")
    public String detailedBlog(){
        return "inner";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/signup")
    public String signUp(){
        return "signup";
    }

    @GetMapping("/create_post")
    public String createPost(){
        return "create-post";
    }

}
