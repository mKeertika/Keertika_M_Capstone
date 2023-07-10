package org.perscholas.KeertikamSpringBootBlogAppCapstone.controller;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.user.IUserService;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class signupController {

private IUserService userService;

//Constructor
    @Autowired
    public signupController(IUserService userService) {
        this.userService = userService;
    }

@GetMapping("/signup")
public String signupDisplay(Model model){

    User newUser = new User();
//    adding data to user table in db
    model.addAttribute("user", newUser);
        return "/users/user-detail-page";


}

    @PostMapping("/signup")
    public String signupUser(@ModelAttribute("user") User user, Model model) {
        User existingUser = userService.getUserByName(user.getUserName());

//        checking whether user already exist in db
        if (existingUser != null) {
            model.addAttribute(
                    "error",
                    "Username already exists. Please choose a different username.");
            return "signup";
        }
        userService.saveUser(user);
        return "redirect:/login";
    }
}
