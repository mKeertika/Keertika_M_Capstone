package org.perscholas.KeertikamSpringBootBlogAppCapstone.controller;

import org.apache.catalina.User;
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
                             Model model){

        if(bindingResult.hasErrors()){
            return "redirect:/persons/person-detail-page";
        }

        if((personService.getPersonByPersonName(person.getPersonName())!=null))
        {
           model.addAttribute("msg", "User already exists.");
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
                                    Model model){

//     get student from database by id
        Person existingPerson = personService.getPersonById(personId);

        if(existingPerson.getEmail()!=null){
            model.addAttribute("message", "User with this name already exists.");
            personService.getPersonById(personId);
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



    @GetMapping("/person-profile-dashboard/{personId}")
    public String demo(@PathVariable("personId") Long personId, Model model){
        Person person = personService.getPersonById(personId);
        model.addAttribute("person", person);
        List<UserPost> postListByPersonId = person.getUserPostsByPersonName(person.getPersonName());
        model.addAttribute("userPostList", postListByPersonId);
        return ("/persons/person-profile-dashboard");
    }

}
