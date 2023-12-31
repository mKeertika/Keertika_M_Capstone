package org.perscholas.KeertikamSpringBootBlogAppCapstone.controller;

//import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.PostImage;

import org.apache.catalina.User;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.Person;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.PostComment;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.UserPost;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.services.ICommentService;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.services.IPostService;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class PostController {

    private IPostService postService;
    private IPersonService personService;
    private ICommentService commentService;

//    Constructor

    @Autowired
    public PostController(IPostService postService, IPersonService personService) {
        this.postService = postService;
        this.personService = personService;
    }


    @GetMapping("/")
    public String home(Model model) {
//fetching data from DB
        model.addAttribute("listPost", postService.getAllUserPost());
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
    public String savePost(@ModelAttribute("userPost") @Valid UserPost userPost,
                           BindingResult bindingResult,
                           HttpSession httpSession) {

        if (bindingResult.hasErrors()) {
            return "redirect:/create-post";
        }
//        checking whether person already exist
        Person person = personService.getPersonByPersonName(userPost.getAuthor());

//         if not
        if (person == null) {
            person = new Person(userPost.getAuthor(), null, null);
            personService.savePerson(person);
        }

//        if person already exist it will display all post related to that person
        List<UserPost> userPostList = person.getUserPostList();

        //saving post in db
        userPostList.add(userPost);
        personService.saveExistingPerson(person);
        httpSession.setAttribute("userName", person.getPersonName());
        return "redirect:/";
    }

//    @PostMapping("/savePost")
//    public String savePost(@ModelAttribute("userPost") @Valid UserPost userPost,
//                           BindingResult bindingResult) {
//
//        if(bindingResult.hasErrors()){
//            return "redirect:/persons/user-detail-page";
//        }
//
//    postService.savePost(userPost);
//        return "redirect:/";
//    }



    @GetMapping("/updatePost/{postId}")
    public String showPageToUpdatePost(@PathVariable(value = "postId") Long postId, Model model) {

        // get employee through the service from db
        UserPost userPost = postService.getPostById(postId);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("userPost", userPost);
        return "/update-post";
    }


    @GetMapping("/fullPost/{postId}")
    public String fullPost(@PathVariable(value = "postId") Long postId, Model model){

        UserPost postById = postService.getPostById(postId);
        model.addAttribute("post", postById);

//        List<PostComment> allComments = commentService.getAllComments();
//        model.addAttribute("comments", allComments);
        return "/detail-post-page";
    }

    @PostMapping("/updatedPost/{postId}")
    public String showPageToUpdatedPost(@PathVariable(value = "postId")
                                                Long postId,
                                        @ModelAttribute UserPost userPost) {

//     get student from database by id
            UserPost currentPost = postService.getPostById(postId);
            currentPost.setPostId(postId);
            currentPost.setPostTitle(userPost.getPostTitle());
            currentPost.setContent(userPost.getContent());
            currentPost.setAuthor(userPost.getAuthor());

//     save updated student object
            postService.savePost (currentPost);
            return "redirect:/" ;
    }


    @GetMapping("/deletePost/{postId}")
    public String deletePostById(@PathVariable(value = "postId") Long postId) {

        this.postService.deletePostById(postId);
        return "redirect:/";
    }





//    @GetMapping("/deletePost/{postId}")
//    public String deletePostById(@PathVariable(value = "postId") Long postId,
//                                 HttpSession httpSession) {
//        String userName = (String) httpSession.getAttribute("userName");
//        Person user = userService.getUserByUserName(userName);
//        List<UserPost> posts = user.getUserPostList();
//
//        UserPost postById = postService.getPostById(postId);
//        posts.remove(postById);
//
//        userService.saveUser(user);
//        return "redirect:/";
//    }
//
//    @GetMapping("/posts/{userId}")
//    public String getPostsByUserId(@PathVariable Long userId, Model model) {
//        Person user =.findById(userId).orElse(null);
//        if (user != null) {
//            List<UserPost> posts = postService.findByUser(userId);
//            model.addAttribute("posts", posts);
//        }
//        return "persons/user-profile-dashboard";
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

