package org.perscholas.KeertikamSpringBootBlogAppCapstone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {


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
//        return "contact";
    }

    @GetMapping("/detail")
    public String detailedBlog(){
        return "inner";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/create_post")
    public String createPost(){
        return "create-post";
    }

}
