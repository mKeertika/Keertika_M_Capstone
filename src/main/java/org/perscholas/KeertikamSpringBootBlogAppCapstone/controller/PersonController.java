package org.perscholas.KeertikamSpringBootBlogAppCapstone.controller;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.Person;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.UserPost;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.services.IPersonService;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.services.PersonExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@Primary
public class PersonController {

    private IPersonService personService;
    private Long personId;
    private Model model;


    //    constructor
    @Autowired
    public PersonController(IPersonService personService) {
        this.personService = personService;
    }

//  Index page ; top navigation userlist, population users in repo
    @GetMapping("/person-list")
    public String getAllPersons(Model model){

        model.addAttribute("personList", personService.getAllPerson());
        return "persons/person-detail-page";
    }


    @GetMapping("/deletePerson/{personId}")
    public  String deletePersonById(@PathVariable( value="personId") Long personId, Model model){

        this.personService.deletePersonById(personId);
        model.addAttribute("personList", personService.getAllPerson());
        return "persons/person-detail-page";
    }


//    methods to deal with UserPosts on Person profile Dashboard

    @GetMapping("/Persons/{personId}/UserPosts")
    public String showUserPostsByPersonId(@PathVariable Long personId, Model model) {
        Person person = personService.getPersonById(personId);
        List<UserPost> UserPostList = person.getUserPostList();
        model.addAttribute("UserPost", UserPostList);
        return "/Persons/person-profile-dashboard";
    }


    @PostMapping("/savePerson")
    public String savePerson(@ModelAttribute("person") @Valid Person person,
                             BindingResult bindingResult,
                             HttpSession httpSession){

        if(bindingResult.hasErrors()){
            return "redirect:/persons/person-detail-page";
        }

        if((personService.getPersonByPersonName(person.getPersonName())!=null))
        {
           httpSession.setAttribute("msg", "User already exist.");
            return "/signup";
//            throw new PersonExistsException();

        } else {
//        saved to db
        personService.savePerson(person);
        return "persons/person-profile-dashboard";}
    }


//    request for editing user details on "person-detail-page.html", by hitting edit button
    @GetMapping("editPerson/{personId}")
    public  String editPersonById(@PathVariable( value="personId") Long personId, Model model){

        Person person = personService.getPersonById(personId);
        model.addAttribute("person", person);
        return "/persons/edit-person-detail";
    }

//    for updating user details by clicking update button on "edit-person-detail.html"
    @PostMapping("/saveUpdatedPerson/{personId}")
    public String saveUpdatedPerson(@PathVariable(value="personId") Long personId,
                                  @ModelAttribute("person") @Valid Person person,
                                    HttpSession httpSession){

//     get student from database by id
        Person existingPerson = personService.getPersonById(personId);

        if(existingPerson.getEmail()!=null){
            httpSession.setAttribute("message", "User with this email id already exists.");
            return "/persons/edit-person-detail";
        }

        existingPerson.setPersonId(personId);
        existingPerson.setPersonName(person.getPersonName());
        existingPerson.setEmail(person.getEmail());
        existingPerson.setPassword(person.getPassword());

//     save updated person object
        personService.saveExistingPerson(existingPerson);
        return "redirect:/person-list" ;
    }


//
//
//    @GetMapping("/{personId}/blogs/{blogId}/edit")
//    public String editBlog(@PathVariable Long personId, @PathVariable Long postId, Model model) {
//        UserPost UserPost = PersonService.getUserPostById(personId, postId);
//        model.addAttribute("UserPost", UserPost);
//        // Add necessary code to handle blog editing
//        return "edit-post";
//    }
//
//    @GetMapping("/{personId}/blogs/{UserPostId}/delete")
//    public String deleteBlog(@PathVariable Long personId, @PathVariable Long UserPostId) {
//        PersonService.deleteUserPostById(personId, UserPostId);
//        // Add necessary code to handle blog deletion
//        return "redirect:/Persons/{personId}/blogs";
//    }
}