package org.perscholas.KeertikamSpringBootBlogAppCapstone.controller;

//import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.PostImage;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.User;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.UserPost;
//import org.perscholas.KeertikamSpringBootBlogAppCapstone.services.IPostImageService;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.services.IPostService;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private IPostService postService;

    @Autowired
    private IUserService userService;

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
//        checking whether user already exist

        User user=userService.getUserByUserName(userPost.getAuthor());

//         if not
        if(user==null){
            user= new User(userPost.getAuthor(), null, null);

            userService.saveUser(user);
        }

//        if user already exist it will display all post related to that user
        List<UserPost> userPostList= user.getUserPostList();

        //saving post in db
        userPostList.add(userPost);
//        saving user to db
        return "redirect:/";
    }


    @GetMapping("/updatePost/{postId}")
    public String showPageToUpdatePost(@PathVariable(value = "postId")  Long postId, Model model){

        // get employee from the service
        UserPost userPost = postService.getPostById(postId);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("userPost", userPost);
        return "/update-post";
    }


    @PostMapping("/updatedPost/{postId}")
    public String showPageToUpdatedPost(@PathVariable(value = "postId")
                                            Long postId, Model model){

        UserPost userPost = postService.getPostById(postId);
//        model.addAttribute("userPost", userPost);
        postService.savePost(userPost);
        return "redirect:/";
    }



    @GetMapping("/deletePost/{postId}")
    public String deletePostById(@PathVariable(value = "postId") Long postId){
        this.postService.deletePostById(postId);
        return "redirect:/";
    }
//
//    @GetMapping("/posts/{userId}")
//    public String getPostsByUserId(@PathVariable Long userId, Model model) {
//        User user =.findById(userId).orElse(null);
//        if (user != null) {
//            List<UserPost> posts = postService.findByUser(userId);
//            model.addAttribute("posts", posts);
//        }
//        return "users/user-profile-dashboard";
//    }


//    Image related methods

//        @GetMapping("/create_post/{postId}")
//        public String showBlogPost(@PathVariable Long postId, Model model) {
//            // Retrieve the Image associated with the blog post
//            PostImage img = imageService.getPostImageByUserPostId(postId);
//
//            if (img != null) {
//                // Pass the image URL to the view
//                model.addAttribute("imageUrl", img.getFilePath());
//            }
//
//            return "/index";
//}
}
