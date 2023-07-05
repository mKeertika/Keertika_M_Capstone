package org.perscholas.KeertikamSpringBootBlogAppCapstone.controller;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.UserPost;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PostController {

    private IPostService postService;

//    Constructor

    @Autowired
    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String home(Model model) {
//fetching data from DB
        model.addAttribute("listPost", postService.getAllPost());
//        returning to index page where all data are displayed
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/detail")
    public String detailedBlog() {
        return "inner";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "signup";
    }


    @GetMapping("/create_post")
    public String createPost(Model model) {

//       to bind dats fetched from the userPost form
        UserPost userPost = new UserPost();
        model.addAttribute("userPost", userPost);
        return "create-post";
    }

    @PostMapping("/savePost")
    public String savePost(@ModelAttribute("userPost")  @Valid UserPost userPost, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "redirect:/create-post";
        }

//        saved to db
        postService.savePost(userPost);
        return "redirect:/";
    }
}
