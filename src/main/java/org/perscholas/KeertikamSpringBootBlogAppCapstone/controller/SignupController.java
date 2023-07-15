package org.perscholas.KeertikamSpringBootBlogAppCapstone.controller;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.Person;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class SignupController {

private IPersonService personService;

//Constructor
    @Autowired
    public SignupController(IPersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/signup")
    public String signUp(Model model) {

        Person newPerson = new Person();
        model.addAttribute("person", newPerson);
        return "signup";
    }

//@GetMapping("/signup")
//public String signupDisplay(Model model){
//
//    Person newUser = new Person();
////    adding data to user table in db
//    model.addAttribute("user", newUser);
//        return "/persons/user-detail-page";
//}

    @PostMapping("/saveNewUser")
    public String signupUser(@ModelAttribute("person") @Valid Person person, Model model) {
        Person existingPerson = personService.getPersonByPersonName(person.getPersonName());

//        checking whether person already exist in db
        if (existingPerson != null) {
            model.addAttribute(
                    "error",
                    "Username already exists. Please choose a different username.");
            return "signup";
        }
        personService.savePerson(person);
        return "/persons/person-profile-dashboard";
    }
}
