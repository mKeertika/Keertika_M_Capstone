package org.perscholas.KeertikamSpringBootBlogAppCapstone.controller;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.User;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.UserPost;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@Primary
public class UserController {

    private IUserService userService;


    //    constructor
    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/";
    }


    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "redirect:/create-post";
        }


//        methods to deal with user display for Super Admin on User Details page

//        saved to db
        userService.saveUser(user);
        return "users/user-profile-dashboard";
    }


    @GetMapping("/users/delete/{userId}")
    public  String deleteUserById(@PathVariable( value="userId") Long userId){

        userService.deleteUserById(userId);
        return "/users/user-detail-page";
    }

    @GetMapping("/users/edit/{userId}")
    public  String editUserById(@PathVariable( value="userId") Long userId, Model model){

        User userById = userService.getUserById(userId);
        model.addAttribute(userById);
        return "/users/user-detail-page";
    }

//    methods to deal with userPosts on user profile Dashboard

    @GetMapping("/users/{userId}/userPosts")
    public String showUserPostsByUserID(@PathVariable Long userId, Model model) {
        User user = userService.getUserById(userId);
        List<UserPost> userPosts = user.getUserPosts();
        model.addAttribute("user", userPosts);
        return "/users/user-profile-dashboard";
    }


    @GetMapping("/{userId}/blogs/{blogId}/edit")
    public String editBlog(@PathVariable Long userId, @PathVariable Long postId, Model model) {
        UserPost userPost = userService.getUserPostById(userId, postId);
        model.addAttribute("userPost", userPost);
        // Add necessary code to handle blog editing
        return "edit-post";
    }

    @GetMapping("/{userId}/blogs/{userPostId}/delete")
    public String deleteBlog(@PathVariable Long userId, @PathVariable Long userPostId) {
        userService.deleteUserPostById(userId, userPostId);
        // Add necessary code to handle blog deletion
        return "redirect:/users/{userId}/blogs";
    }
}
