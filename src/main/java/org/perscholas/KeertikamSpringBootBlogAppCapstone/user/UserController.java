package org.perscholas.KeertikamSpringBootBlogAppCapstone.user;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    private IUserService userService;


    //    constructor
    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String home(Model model) {
//fetching data from DB
        model.addAttribute("listPost", postService.getAllPost());
//        returning to index page where all data are displayed
        return "index";
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
