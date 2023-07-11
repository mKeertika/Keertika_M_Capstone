package org.perscholas.KeertikamSpringBootBlogAppCapstone.controller;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.UserPost;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "/index";
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


//    Already defined in user/UserController
//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }


//    Already defined in user/SignupController
//    @GetMapping("/signup")
//    public String signUp() {
//        return "signup";
//    }


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


    @GetMapping("/updatePost/{postId}")
    public String showPageToUpdatePost(@PathVariable(value = "postId")  Long postId, Model model){
//        UserPost userPostById = postService.getPostById(postId);
//        model.addAttribute("userPost", userPostById);
        UserPost updatedPost = postService.getPostById(postId);
        updatedPost.setPostTitle(updatedPost.getPostTitle());
        updatedPost.setContent(updatedPost.getContent());
       // postService.savePost(updatedPost);
        model.addAttribute(updatedPost);

        return "/update-post";
    }




    @GetMapping("/deletePost/{postId}")
    public String deletePostById(@PathVariable(value = "postId") Long postId){
        this.postService.deletePostById(postId);
        return "redirect:/";
    }
}
