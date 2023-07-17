package org.perscholas.KeertikamSpringBootBlogAppCapstone.controller;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.UserPost;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.services.IPersonService;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestPersonController {

    private IPersonService personService;
    private IPostService postService;

    @Autowired
    public RestPersonController(IPersonService personService) {
        this.personService = personService;
    }


    @GetMapping("/")
    public List<UserPost> listAllPosts() {
        List<UserPost> allPosts = postService.getAllUserPost();
        return allPosts;
    }


}
