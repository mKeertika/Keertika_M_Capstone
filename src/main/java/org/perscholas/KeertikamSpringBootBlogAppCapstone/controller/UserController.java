package org.perscholas.KeertikamSpringBootBlogAppCapstone.controller;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.UserPost;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.services.IPostService;
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

}
