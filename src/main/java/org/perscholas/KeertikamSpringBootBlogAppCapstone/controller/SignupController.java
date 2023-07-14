package org.perscholas.KeertikamSpringBootBlogAppCapstone.controller;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.services.IUserService;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class SignupController {

private IUserService userService;

//Constructor
    @Autowired
    public SignupController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signUp(Model model) {

        User newUser = new User();
        model.addAttribute("user", newUser);
        return "signup";
    }

//@GetMapping("/signup")
//public String signupDisplay(Model model){
//
//    User newUser = new User();
////    adding data to user table in db
//    model.addAttribute("user", newUser);
//        return "/users/user-detail-page";
//}

    @PostMapping("/saveNewUser")
    public String signupUser(@ModelAttribute("user") @Valid User user, Model model) {
        User existingUser = userService.getUserByUserName(user.getUserName());

//        checking whether user already exist in db
        if (existingUser != null) {
            model.addAttribute(
                    "error",
                    "Username already exists. Please choose a different username.");
            return "signup";
        }
        userService.saveUser(user);
        return "/users/user-profile-dashboard";
    }
}
